package TESTDEMO;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonLogin {
	WebDriver dr;
  @Test
  public void f() {
	  dr=new ChromeDriver();
	  dr.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=676742245123&hvpos=&hvnetw=g&hvrand=2318026101933754327&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302713&hvtargid=kwd-10573980&hydadcr=14453_2367553&gad_source=1");
	  dr.manage().window().maximize();
	  dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  dr.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();
	  System.out.println(dr.getTitle());
	  dr.getTitle();
	  dr.close();
  }
}
