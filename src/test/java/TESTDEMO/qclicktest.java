package TESTDEMO;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class qclicktest {WebDriver dr;
  @Test
  public void f() {
      ChromeOptions op=new ChromeOptions();op.addArguments("--disable noyifications");
	  dr=new ChromeDriver(op);
	  dr.get("https://rahulshettyacademy.com/AutomationPractice");
	  dr.manage().window().maximize(); dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  JavascriptExecutor js=(JavascriptExecutor)dr;
	  js.executeScript("arguments[0].scrollIntoView()", dr.findElement(By.xpath("//*[@id=\"gf-BIG\"]")));
	  System.out.println(dr.findElement(By.xpath("//*[@id=\"gf-BIG\"]")).findElements(By.tagName("a")).size());
      dr.quit();
  }
}
