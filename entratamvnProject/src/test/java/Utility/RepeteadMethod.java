package Utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepeteadMethod {
	public static WebDriverWait wait;
	//public WebDriver driver;
	
	public static void visibilityOf(WebDriver driver,WebElement element) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public static void PrintElement(List<WebElement>element) {
		try {
			Thread.sleep(500);
			int i =element.size();
			String count=String.valueOf(i);
			Log.info("Size of elemet is :"+count);
			Thread.sleep(500);
			for(WebElement ele:element) {
				Thread.sleep(500);
				Log.info(ele.getAttribute("value"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void SelectElement(List<WebElement>element,String text) {
		try {
			Thread.sleep(500);
			int i =element.size();
			String count=String.valueOf(i);
			Log.info("Size of elemet is :"+count);
			Thread.sleep(500);
			for(WebElement ele:element) {
				Thread.sleep(500);
				if(ele.getAttribute("value").equalsIgnoreCase(text)) {
					ele.click();
					break;
				}
			}
			Log.info("Selected element is :"+text);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void brokenlink(List<WebElement> link, WebDriver driver) throws InterruptedException  {
		int brokenlink=0;
		int Activelink=0;
		for(WebElement links:link) {
			String url=links.getDomAttribute("href");
			if(url!=null && !url.isEmpty()) {
				int statuscode=gethttpresponsecode(url);
				if(statuscode==HttpURLConnection.HTTP_OK) {
	                 Log.info("*****Link is working fine: " + url);
	                 Activelink++;
	             } else {
	            	 Log.info("Broken link found: " + url + " [Status Code: " + statuscode + "]");
	                 brokenlink++;
	             }
		}
	}Log.info("no of Active link is =="+Activelink+"  "+"No of broken link is =="+brokenlink);
		
		
	}
	private static int gethttpresponsecode(String url) throws InterruptedException  {
		// TODO Auto-generated method stub
		try {
		URL href=new URL(url);
		HttpURLConnection connection=(HttpURLConnection) href.openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		Thread.sleep(500);
		return connection.getResponseCode();
		}catch(IOException e){
			return -1;
		}
	
	}
}
