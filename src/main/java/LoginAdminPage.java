import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAdminPage extends AbstractPage {
    public final static String url = "http://localhost/litecart/admin/login.php";

    LoginAdminPage(){
        driver.get(url);
    }

    @FindBy(css="input[name=\"username\"]")
    WebElement usernameField;

    @FindBy (css="input[name=\"password\"]")
    WebElement passwordField;

    @FindBy (css="button[name=\"login\"]")
    WebElement loginButton;


    public LoginAdminPage setUserName(String text){
        DriverHelper.inputText(usernameField, text);
        return this;
    }

    public LoginAdminPage setPassword(String text){
        DriverHelper.inputText(passwordField, text);
        return this;
    }

    public void clickLoginButton() {
        DriverHelper.clickElement(loginButton);
    }

    public void loginToAdminPanel(String userName, String password) {
        setUserName(userName).setPassword(password).clickLoginButton();
    }
}
