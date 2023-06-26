package ru.netologi.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AutInfo {
        private String login;
        private String password;
    }

    public static AutInfo getValideteAutInfo() {
        return new AutInfo("vasya", "qwerty123");
    }

    public static AutInfo getNoValideteAutInfo(AutInfo fake) {
        return new AutInfo("pety", "123qwerty");
    }

    @Value
    public static class ValidetionCode {
        private String code;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthCode {
        private String id;
        private String user_id;
        private String code;
        private String created;
    }

}
