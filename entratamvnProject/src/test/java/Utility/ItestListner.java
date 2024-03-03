package Utility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Tests.BaseTest;





public class ItestListner extends BaseTest implements ITestListener  {
	public void onTestFailure(ITestResult result) {
		if(result.getThrowable() != null) {
			StringWriter sw=new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			Log.info(sw.toString());}

        File file=  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  byte[] encoded=null;
          try {
        	  encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        	  } catch (IOException e1) {
        	  // TODO Auto-generated catch block
        	  e1.printStackTrace();
        	  }
          Map<String,String>params=new HashMap<String,String>();
          
      	params=	 result.getTestContext().getCurrentXmlTest().getAllParameters();
        String imagePath="Screenshot"+File.separator+TakeScreenshot.currentdate()+File.separator+result.getName()+".png";
        String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;

        try {
        FileUtils.copyFile(file, new File(imagePath));
        Reporter.log("<a href='"+completeImagePath+"'> <img src='"+completeImagePath+"'height='100' width='100'/> </a>");
        }catch(Exception e) {
      	  e.printStackTrace();
        }
		
        try {
		    ExtentReport.getTest().fail("Test Failed",
		    		MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());
		    ExtentReport.getTest().fail("Test Failed",
		    		MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		    		
		    }
		    
		    catch(Exception e) {
		    	e.printStackTrace();
		    }
		    ExtentReport.getTest().fail(result.getThrowable());
	
	
	}
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
		.assignAuthor("Vaishali Shivankar");
		 
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    ExtentReport.getTest().log(Status.PASS, "Test Passed...!");
	  }
    @Override
    public void onTestSkipped(ITestResult result) {
    	 ExtentReport.getTest().log(Status.SKIP, "Test Skipped...!");
    }
   @Override
   public void onFinish(ITestContext context) {
	     ExtentReport.getReporter().flush();
	  }
}
