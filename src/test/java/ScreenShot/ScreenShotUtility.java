package ScreenShot;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
  public static void TakeScreenshot(WebDriver dr)
  {
	  TakesScreenshot ts=(TakesScreenshot) dr;
	  File ActualScreenshot=ts.getScreenshotAs(OutputType.FILE);
	  File Store=new File("C:\\Users\\JAIKAMESH\\eclipse-workspace\\DEMO\\DemoProjectScreenshot\\pic"+System.currentTimeMillis()+".png");
	  
	  try{FileHandler.copy(ActualScreenshot, Store);}
	  catch(IOException e) {e.printStackTrace();}
  }
}
