package TESTDEMO;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.*;
import org.testng.annotations.*;
import LoginPackage.Qclickable_Function;

public class QclickParctice2 {WebDriver dr; Qclickable_Function Func;

	@Test
	public void WelcomePage() throws Exception {
		Func.RadioButtonTEST();
		Func.SuggessionClassExample();
		Func.DropdownExample();
		Func.CheckboxExample();
		Func.SwitchWindowExample();
		Func.SwitchTabExample();
		Func.SwitchToAlertExample();
		Func.ElementDisplayedExample();
		Func.WebTableExample();
		Func.WebTableFixedheader();
		Func.MouseHoverExample();
	}
	
	@BeforeTest
	  public void  Login() {
		  ChromeOptions op=new ChromeOptions();op.addArguments("--disable notifications");
		  dr=new ChromeDriver(op); Func = new Qclickable_Function(dr);
		  
		  dr.get("https://rahulshettyacademy.com/AutomationPractice");
		  dr.manage().window().maximize(); dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  Assert.assertEquals(true, dr.findElement(By.xpath("/html/body/header/a[1]/img")).isDisplayed(),"Image is not displayed");
		  Assert.assertEquals(true, dr.findElement(By.xpath("/html/body/h1")).isDisplayed(),"Practice page is not displayed");}

	@AfterTest
	public void logout() {dr.quit();}
}
