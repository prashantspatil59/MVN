package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.Log;
import Utility.RepeteadMethod;

public class DemoFormPage {
public WebDriver driver;
    public JavascriptExecutor js;
    public Actions act;
    
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement firstName;
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement lastName;
	@FindBy(xpath="//input[@id='Email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='Company']")
	private WebElement companyName;
	@FindBy(xpath="//input[@id='Phone']")
	private WebElement phoneNumber;
	@FindBy(xpath="//select[@id='Unit_Count__c']")
	private WebElement unitCount;
	@FindBy(xpath="//input[@id='Title']")
	private WebElement jobTitel;
	@FindBy(xpath="//select[@id='demoRequest']")
	private WebElement IamTab;
	@FindBy(xpath="//select[@id='Unit_Count__c']/option")
	private List<WebElement>unitList ;
	@FindBy(xpath="//select[@id='demoRequest']/option")
	private List<WebElement>iamList ;
	@FindBy(xpath="//div[@id='ValidMsgTitle']")
	private WebElement validmsgTitel;
	@FindBy(xpath="//div[@id='ValidMsgEmail']")
	private WebElement valismsgEmail;
	@FindBy(xpath="//span[contains(text(),'example@yourdomain.com')]")
	private WebElement valismsgEmailtext;
	@FindBy(xpath="(//a[@href='https://go.entrata.com/watch-demo.html'])[1]")
	private WebElement watchDemoLink;
    @FindBy(xpath="//div[@id='mkto_gen_asdfdfd9']//a")
    private WebElement entrataLinkDemoPage;
    
    
	public DemoFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		act=new Actions(driver);
	}
	
	
	public void clickOnentrataLink() {
		try {
		RepeteadMethod.visibilityOf(driver, entrataLinkDemoPage);
		entrataLinkDemoPage.click();
		Log.info("Click On entrata Link");}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void watchDemoClick() throws InterruptedException {
		RepeteadMethod.visibilityOf(driver,watchDemoLink);
		watchDemoLink.click();
	
		String url=driver.getCurrentUrl();
		
		
		Log.info("The current page url is "+url);
		Log.info("Verify for DemoPage Url");
		Assert.assertEquals(url,"https://go.entrata.com/watch-demo.html");
	}
	public void firstNameTextbox(String name) {

	RepeteadMethod.visibilityOf(driver,firstName);
	firstName.sendKeys(name);
	Log.info("Click On First Name textox and Enter Name is :"+name);
	}
	public void lastNameTextbox(String name) {
		RepeteadMethod.visibilityOf(driver,lastName);
		lastName.sendKeys(name);
		Log.info("Click on Last Name textbox And Name is :"+name);
	}
	public void emailTextBox(String Email) {
		RepeteadMethod.visibilityOf(driver,email);
		email.sendKeys(Email);
		Log.info("Click on  Email textbox And email is :"+Email);
	}
	public void companyNameTextBox(String name) {
		RepeteadMethod.visibilityOf(driver,companyName);
        companyName.sendKeys(name);
        Log.info("Click on Companyname textbox and name is : "+name);
	}
	public void phoneNumberTextbox(String number) {
		RepeteadMethod.visibilityOf(driver,phoneNumber);
		phoneNumber.sendKeys(number);
		 Log.info("Click on phoneNumber textbox and Number is : "+number);
	}
	public void jobTitelTextbox(String name) {
		RepeteadMethod.visibilityOf(driver,jobTitel);
		jobTitel.sendKeys(name);
		 Log.info("Click on Job Titel textbox and Titel is : "+name);
	}
	public void iAMTab() {
		RepeteadMethod.visibilityOf(driver,IamTab);
		IamTab.click();
		Log.info("Click on I am Tab");
	}
	public void unitCountTab() {
		RepeteadMethod.visibilityOf(driver,unitCount);
		unitCount.click();
		Log.info("Click on Unit count tab");
		
	}
	public void selectUnitCount(String name) {
		RepeteadMethod.PrintElement(unitList);
		RepeteadMethod.SelectElement(unitList, name);
	}
	public void selectIamOption(String name) throws InterruptedException {
		RepeteadMethod.PrintElement(iamList);
		RepeteadMethod.SelectElement(iamList, name);
		Thread.sleep(1000);
		
	}
	public void Scroll(int num1,int num2) {
		 js.executeScript("window.scrollBy('"+num1+"','"+num2+"');");
	}
}
