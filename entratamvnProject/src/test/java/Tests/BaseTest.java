package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import Utility.PropReader;



public class BaseTest {
public static WebDriver driver;
@BeforeSuite
public void launchbrowser() throws Exception {
	//step 1 intilaise driver
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(PropReader.readproperties("url"));
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@AfterTest
public void tear() {
	try {
	driver.close();}catch (Exception e) {
		// TODO: handle exception
	}
}}
