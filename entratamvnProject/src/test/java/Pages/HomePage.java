package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.Log;
import Utility.RepeteadMethod;

public class HomePage {
	public WebDriver driver;
	 public JavascriptExecutor js;
	    public Actions act;
	    
	 @FindBy(xpath="//a")
	 private List<WebElement>linkInPages;
	@FindBy(xpath="//a[@class='main-header-logo']")
	private WebElement entrataLink;
	@FindBy (xpath="//div[@class='cookie-intro-align']")
	private WebElement cookiesText;
	@FindBy (xpath="//button[@id='rcc-confirm-button']")
	private WebElement cookiesAccept;
	@FindBy(xpath="(//div[@class='main-nav-link'])[1]")
	private WebElement product;
	@FindBy(xpath="(//div[@class='main-nav-link'])[2]")
	private WebElement solution;
	@FindBy(xpath="(//div[@class='main-nav-link'])[3]")
	private WebElement resourses;
	@FindBy(xpath="(//div[@class='header-nav-item'])[4]")
	private WebElement baseCamp;
	@FindBy(xpath="(//div[@class='nav-group'])//a")
	private List<WebElement>ProductTabAllLinks;
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		act=new Actions(driver);
	}
	
	public void AcceptCookies() {
		try {
		RepeteadMethod.visibilityOf(driver,cookiesText );
		String text=cookiesText.getText();
		Log.info("Cookies Text is :"+text);
		cookiesAccept.click();
		Log.info("Click on Accept Cookies");
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void clickOnentrataLink() {
		RepeteadMethod.visibilityOf(driver, entrataLink);
		entrataLink.click();
		Log.info("Click On entrata Link");
	}
	public void VerifyForHomePageUrl() {
		String url=driver.getCurrentUrl();
		Log.info("Url of Home page is :"+url);
		Log.info("Verify for Url");
		Assert.assertEquals(url,url);
	}
	public void verifyAllLinksHomePage() throws InterruptedException {
		Log.info("****************Verify for all links(active and broken) in the page *******************");
		RepeteadMethod.brokenlink(linkInPages, driver);
		Thread.sleep(5000);
	}
	public void VerifyAllLinksInTheProduct() throws InterruptedException {
		//product.click();
		RepeteadMethod.visibilityOf(driver, product);
		Thread.sleep(2000);
		act.moveToElement(product).build().perform();;
		Log.info("Mouse hovering towards product");
		Log.info("****************Now Verify all the active and broken links in Product tab ***********");
		RepeteadMethod.brokenlink(ProductTabAllLinks, driver);
		Thread.sleep(5000);
	}
	
}
