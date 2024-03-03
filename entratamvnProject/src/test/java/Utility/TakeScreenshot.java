package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Tests.BaseTest;



public class TakeScreenshot extends BaseTest{



public static void screenshot(WebDriver driver,String name) {
	// TODO Auto-generated method stub
	String path=System.getProperty("user.dir")+"\\ScreenShot\\"+name+".png";
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(path);
	try {
		FileUtils.copyFile(src,dst);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static String currentdate() {
	DateFormat pattern =new SimpleDateFormat("dd-mm-yyyy");
	Calendar cal=Calendar.getInstance();
	String curentdate=pattern.format(cal.getTime());
	return curentdate;
	
	
	
	
	
}
}
