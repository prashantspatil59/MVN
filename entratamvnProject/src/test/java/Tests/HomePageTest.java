package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest extends BaseTest {
	HomePage hp;

	public void initobject() {
     hp=new HomePage(driver);
	}

	@BeforeClass
	public void driverinitilization() {
		initobject();
	}
    @Test(testName="Verify Page url",priority=1,enabled=true)
    public void verifyPageUrl() {
    	hp.AcceptCookies();
    	hp.VerifyForHomePageUrl();
    }
    @Test(testName="Verify page links",priority=2,enabled=true)
    public void verifyAllThePageLinks() throws InterruptedException {
    	hp.verifyAllLinksHomePage();
    }
    @Test(testName="Verify Product links",priority=3,enabled=true)
    public void verifyAllTheLinkInProduct() throws InterruptedException {
    	hp.VerifyAllLinksInTheProduct();
    }
}
