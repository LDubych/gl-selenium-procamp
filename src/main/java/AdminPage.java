import org.junit.Assert;

public class AdminPage extends AbstractPage{
    public final static String url = "http://localhost/litecart/admin/";

    AdminPage(){
    }

    public void assertIsAdminPanel() {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
}
