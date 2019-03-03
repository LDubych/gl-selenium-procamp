import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DriverHelper {
    private static final WebDriver driver;
    private static Map<String, String> env = System.getenv();
    private static Properties prop = new Properties();

    static {
        WebDriver tmp = null;//new ChromeDriver();
        for (String envName : env.keySet()) {

            if (envName.equals("env")) {
                System.out.format("%s=%s%n",
                        envName,
                        env.get(envName));
                try {
                    prop.load(new FileInputStream(String.format("src/main/resources/%s.properties", env.get(envName))));
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
                switch (prop.getProperty("webdriver")) {
                    case "firefox":
                        tmp = new FirefoxDriver();
                        break;
                    case "chrome":
                    default:
                        tmp = new ChromeDriver();
                        break;
                }
            }
        }
        driver = tmp;
        if (driver == null){
            System.out.println("No env var");
        }

    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void quitDriver(){
        driver.quit();
    }

    static void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    static void clickElement(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator))).click();
    }

    static void inputText(WebElement element, String text, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    static void inputText(WebElement element, String text) {
        inputText(element, text, 10);
    }

    static void waitPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"http://localhost/litecart/admin/\"]")));
    }

    static List<WebElement> getElements(String selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector)));
    }

    static List<WebElement> getElements(String selector, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector)));
    }

}
