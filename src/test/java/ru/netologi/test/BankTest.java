package ru.netologi.test;



import org.junit.jupiter.api.Test;
import ru.netologi.data.DataHelper;
import ru.netologi.data.SQLHelper;
import ru.netologi.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BankTest {
    @Test
    void shouldsuccessfulLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        loginPage = new LoginPage();
        var authInfo = DataHelper.getValideteAutInfo();
        var varificationPage = loginPage.validlogin(authInfo);
        varificationPage.verificationPage();
        var varificationCode = SQLHelper.getValidetionCode();
        varificationPage.validVerify(varificationCode.getCode());
    }
}
