import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BasicPageTest {
    static WebDriver driver;
    static BasicPage basicPage;
    static String baseUrl = "http://localhost/litecart";

    @BeforeClass
    public static void Setup() {
        driver = DriverHelper.getDriver();
        driver.get(baseUrl);
        basicPage = new BasicPage();
    }

    @Test
    public void Test1() {

    }

    @AfterClass
    public static void TearDown() {
        driver.quit();
    }
}
