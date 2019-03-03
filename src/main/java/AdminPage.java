import com.google.common.base.Strings;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import static java.lang.String.format;

public class AdminPage extends BasicPage{
    public final static String url = "http://localhost/litecart/admin/";
    public  final static String childElement = ":nth-child(%s)";
    public  final static String menuItems = "#box-apps-menu #app-";
    public  final static String menuItemTemplate = menuItems+childElement;
    public  final static String menuSubItems = "li[id*=doc-]";
    public  final static String menuSubItemTemplate = menuSubItems+childElement;
    public  final static String H1 = "h1";

    AdminPage(){
        new LoginAdminPage().loginToAdminPanel("admin", "admin");
        DriverHelper.waitPageLoad();
    }

    AdminPage(Boolean openPage){
        if (openPage && !driver.getCurrentUrl().equals(url)) {
            driver.get(url);
            DriverHelper.waitPageLoad();
        } else {
            new AdminPage();
        }
    }


    @FindBy(css = menuItems)
    List <WebElement> menuItemsList;

    public void assertIsAdminPanel() {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    public void assertIsh1Present() {
        Assert.assertTrue(DriverHelper.getElements(H1).size()>0);
        System.out.println("Element H1 is present");
    }

    public List<WebElement> getSubMenu(){
        return DriverHelper.getElements(menuSubItems,1);
    }
}
