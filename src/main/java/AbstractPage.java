import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    public final static WebDriver driver = DriverHelper.getDriver();

    AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public static void quitDriver(){
        driver.quit();
    }


}
