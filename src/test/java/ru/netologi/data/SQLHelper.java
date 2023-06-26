package ru.netologi.data;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lombok.SneakyThrows;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    public static DataHelper.ValidetionCode getValidetionCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER by created DESC LIMIT 1";
        try (var conn = getConn()) {
            var code = runner.query(conn, codeSQL, new ScalarHandler<String>());
            return new DataHelper.ValidetionCode(code);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static void CleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "delete from auth_codes");
        runner.execute(connection, "delete from card_transactions");
        runner.execute(connection, "delete from cards");
        runner.execute(connection, "delete from users");
    }

}


