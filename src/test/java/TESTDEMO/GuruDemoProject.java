package TESTDEMO;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

public class GuruDemoProject {WebDriver dr;
By GuruUser=By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
By GuruPassword=By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
By LoginButton=By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]");
  

@Test(dataProvider = "Crediential")
  public void Test(String User, String Password) throws InterruptedException, UnhandledAlertException 
 {
	 dr.findElement(GuruUser).sendKeys(User);
	 dr.findElement(GuruPassword).sendKeys(Password);
	 
	 try {
	 dr.findElement(LoginButton).click();}
	 catch(UnhandledAlertException f){
		 try{
		 dr.switchTo().alert().accept();
         System.out.println("FAIL");}
		 catch(NoAlertPresentException e)
		 {
			 System.out.println("PASS");
			 e.printStackTrace();
		 }
	 }
  }
  
@BeforeTest
public void login()
   {
	  //ChromeOptions op=new ChromeOptions();op.addArguments("--disable noyifications");
	  dr=new ChromeDriver();
	  dr.get("https://clicks.aweber.com/y/ct/?l=qh6&m=mqr21DGG7WFEjy9&b=ftyRAGqn86J.zqoUqwX_JA");
	  dr.manage().window().maximize(); dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

@DataProvider
public Object[][] Crediential() {return new Object[][] 
{ new Object[] { "Dummy", "123456" },new Object[] { "SecondDemo", "Test" },
	new Object[] { "mngr569038", "UdepEsY" },};

}}
