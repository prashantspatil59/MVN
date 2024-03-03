package Tests;

import org.testng.annotations.*;
import Pages.DemoFormPage;
import Pages.HomePage;
import Utility.PropReader;

public class DemoFormTest extends BaseTest{
    DemoFormPage dfp;
    HomePage hp;
	public void initobject() {
     dfp=new DemoFormPage(driver);
     hp=new HomePage(driver);
	}

	@BeforeClass
	public void driverinitilization() {
		initobject();
	}
    
	@Test(testName="E2E test for Fill the form",enabled=true,priority=1)
	public void E2ETestForFillForm() throws Exception {
		dfp.watchDemoClick();
		dfp.firstNameTextbox(PropReader.readproperties("FN"));
		dfp.lastNameTextbox(PropReader.readproperties("LN"));
		dfp.emailTextBox(PropReader.readproperties("email"));
		dfp.companyNameTextBox(PropReader.readproperties("companyName"));
		dfp.phoneNumberTextbox(PropReader.readproperties("phoneNumber"));
		dfp.unitCountTab();
		dfp.selectUnitCount(PropReader.readproperties("unitop4"));
		dfp.jobTitelTextbox(PropReader.readproperties("jobTitel"));
		Thread.sleep(1000);
		dfp.Scroll(0,500);
    	dfp.iAMTab();
		dfp.selectIamOption(PropReader.readproperties("iAmOp2"));
		dfp.Scroll(0,-3000);
		//Thread.sleep(5000);
	}
	@Test(testName="Verify for link entrata nevigate to home page or not",priority=2,enabled=true)
	public void VerifylinkEntrata() {
		dfp.clickOnentrataLink();
		hp.VerifyForHomePageUrl();
	}
}
