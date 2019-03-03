import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPageTest {

    private static AdminPage adminPage;

    @BeforeClass
    public static void Setup() {
        adminPage = new AdminPage();
    }

    @Test
    public void clickToAllMenuItems() throws Exception {
        for (int i = 0; i < adminPage.menuItemsList.size(); i++) {
            DriverHelper.clickElement(String.format(AdminPage.menuItemTemplate, i + 1));
            try {
                List<WebElement> subItems = adminPage.getSubMenu();
                for (int j = 0; j < subItems.size(); j++) {
                    DriverHelper.clickElement(String.format(AdminPage.menuSubItemTemplate, j + 1));
                    adminPage.assertIsh1Present();
                }

            } catch (TimeoutException e) {
                adminPage.assertIsh1Present();
            }
            DriverHelper.waitPageLoad();
        }

    }

    @AfterClass
    public static void TearDown() {
        AdminPage.quitDriver();
    }
}
