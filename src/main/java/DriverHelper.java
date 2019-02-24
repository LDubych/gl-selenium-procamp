import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class DriverHelper {
    private static WebDriver driver;
    private static Map<String, String> env = System.getenv();
    private static Properties prop = new Properties();

    static WebDriver getDriver() {
        for (String envName : env.keySet()) {

            if (envName.equals("env")) {
                System.out.format("%s=%s%n",
                        envName,
                        env.get(envName));
                try {
                    prop.load(new FileInputStream(String.format("src/main/resources/%s.properties", env.get(envName))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                switch (prop.getProperty("webdriver")) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                }
                return driver;
            }
        }
        System.out.println("No env var");
        return driver;
    }
}
