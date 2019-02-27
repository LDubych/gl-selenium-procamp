import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginToAdminTest {
    private static LoginAdminPage loginAdminPage;

    @BeforeClass
    public static void Setup() {
        loginAdminPage = new LoginAdminPage();
    }

    @Test
    public void LoggingToAdminPanel_ValidData() {
        loginAdminPage.loginToAdminPanel("admin", "admin");
        DriverHelper.waitPageLoad();
        Assert.assertEquals(AdminPage.url, LoginAdminPage.driver.getCurrentUrl());
    }

    @AfterClass
    public static void TearDown() {
        LoginAdminPage.quitDriver();
    }

}
