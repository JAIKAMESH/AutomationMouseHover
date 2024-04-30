package LoginPackage;

import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ScreenShot.ScreenShotUtility;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Qclickable_Function {
WebDriver dr;
File Fil;FileOutputStream fos;
XSSFWorkbook wb;XSSFSheet Sheet;

public Qclickable_Function(WebDriver dr) {this.dr = dr;}

public void RadioButtonTEST() {
	for (int i = 0; i < dr.findElements(By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/label")).size(); i++) {
		if ((dr.findElement(By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/label[" + (i + 1) + "]/input"))
				.isSelected()) == false)
			dr.findElement(By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/label[" + (i + 1) + "]/input")).click();
		System.out.println("Radio Button " + (i + 1) + " Pass");}}

public void SuggessionClassExample(){
	System.out.println(dr.findElement(By.xpath("//*[@id=\"select-class-example\"]/fieldset/legend")).getText());
	Assert.assertEquals(dr.findElement(By.xpath("//*[@id=\"select-class-example\"]/fieldset/legend")).getText(), "Suggession Class Example");
	dr.findElement(By.xpath("//*[@id=\"autocomplete\"]")).sendKeys("INDIA");
	dr.findElement(By.xpath("/html/body/ul/li[2]/div")).click();}

public void DropdownExample() {
System.out.println(dr.findElement(By.xpath("/html/body/div[1]/div[3]/fieldset/legend")).getText());
Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[1]/div[3]/fieldset/legend")).getText(), "Dropdown Example");
dr.findElement(By.id("dropdown-class-example")).click();
dr.findElement(By.xpath("//*[@id=\"dropdown-class-example\"]/option[2]")).click();}

public void CheckboxExample() {
System.out.println(dr.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/legend")).getText());
Assert.assertEquals(dr.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/legend")).getText(), "Checkbox Example");

for (int i = 0; i < (dr.findElements(By.xpath("/html/body/div[1]/div[4]/fieldset/label")).size()); i++) {
    if((dr.findElement(By.xpath("//*[@id=\"checkBoxOption"+(i+1)+"\"]")).isSelected())==false) {
    	dr.findElement(By.xpath("//*[@id=\"checkBoxOption"+(i+1)+"\"]")).click();
    System.out.println("Checkbox "+(i+1)+" Pass");}}}

public void SwitchWindowExample() {
System.out.println(dr.findElement(By.xpath("/html/body/div[2]/div[1]/fieldset/legend")).getText());
Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[2]/div[1]/fieldset/legend")).getText(), "Switch Window Example");
dr.findElement(By.id("openwindow")).click();

String MainWindow=dr.getWindowHandle();
Set<String> AllWindow=dr.getWindowHandles();

for(String Handle:AllWindow) {
dr.switchTo().window(Handle);
System.out.println(dr.getTitle());}
dr.switchTo().window(MainWindow);
}

public void SwitchTabExample() throws InterruptedException{
	System.out.println(dr.findElement(By.xpath("/html/body/div[2]/div[2]/fieldset/legend")).getText());
	Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[2]/div[2]/fieldset/legend")).getText(), "Switch Tab Example");
	
	dr.findElement(By.id("opentab")).click();
    String MainWindow=dr.getWindowHandle();
    Set<String> AllWindows=dr.getWindowHandles();
    Iterator<String> itr=AllWindows.iterator();
    String Win1=itr.next(); String Win2=itr.next();
    Thread.sleep(5000);
    
    dr.switchTo().window(Win1);System.out.println(dr.getTitle());
    dr.switchTo().window(Win2);System.out.println(dr.getTitle());
    dr.switchTo().window(MainWindow);}

public void SwitchToAlertExample(){
	System.out.println(dr.findElement(By.xpath("/html/body/div[2]/div[3]/fieldset/legend")).getText());
	Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[2]/div[3]/fieldset/legend")).getText(), "Switch To Alert Example");
    dr.findElement(By.id("name")).sendKeys("Name");
   
    dr.findElement(By.id("alertbtn")).click();
    dr.switchTo().alert().accept();
    dr.findElement(By.id("name")).sendKeys("TEST");
    dr.findElement(By.id("confirmbtn")).click();
    dr.switchTo().alert().accept();
    dr.findElement(By.id("name")).sendKeys("Dismiss");
    dr.findElement(By.id("confirmbtn")).click();
    dr.switchTo().alert().dismiss();}

public void ElementDisplayedExample()
{
	System.out.println(dr.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[1]/legend")).getText());
	Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[1]/legend")).getText(), "Element Displayed Example");
	dr.findElement(By.id("show-textbox")).click();
	dr.findElement(By.id("displayed-text")).sendKeys("TEST12");
}

public void WebTableExample() throws IOException {
	//File Fil=new File("C:\\Users\\JAIKAMESH\\OneDrive\\Desktop\\SelenimExcel\\NEW.xlsx");
	//FileOutputStream fos=new FileOutputStream(Fil);
	//XSSFWorkbook wb=new XSSFWorkbook();
	//XSSFSheet Sheet=wb.createSheet("TEST SHEET");
	
	System.out.println(dr.findElement(By.xpath("/html/body/div[3]/div[1]/fieldset/legend")).getText());
	Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[3]/div[1]/fieldset/legend")).getText(),"Web Table Example");
	
	System.out.println(dr.findElement(By.xpath("/html/body/div[3]/div[1]/fieldset/table/tbody/tr/th[1]")).getText());
	List<WebElement> Column1=dr.findElements(By.xpath("/html/body/div[3]/div[1]/fieldset/table/tbody/tr/td[1]"));
	ScreenShotUtility.TakeScreenshot(dr);
 
	for(WebElement Actual:Column1) {
		System.out.println(Actual.getText());
	//	Sheet.createRow(i);
	//	Sheet.getRow(i).createCell(i);
	//	Sheet.getRow(i).getCell(i).setCellValue(Actual.getText());
	//	i=i+1;
	}
	//wb.close();
	//fos.close();
	}

public void WebTableFixedheader()
{
	System.out.println(dr.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[2]/legend")).getText());
	Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[2]/legend")).getText(), "Web Table Fixed header");
	
/*Headervalidation*/
	for(int i=0;i<(dr.findElements(By.xpath("//*[@id=\"product\"]/thead/tr/th")).size());i++) {
    System.out.print(dr.findElement(By.xpath("//*[@id=\"product\"]/thead/tr/th["+(i+1)+"]")).getText()+" || ");
	}	System.out.println("");
   
	/*validation*/
	for(int i=0;i<(dr.findElements(By.xpath(" /html/body/div[3]/div[2]/fieldset[2]/div[1]/table/tbody/tr/td[1]")).size());i++) {
		for(int j=0;j<(dr.findElements(By.xpath(" /html/body/div[3]/div[2]/fieldset[2]/div[1]/table/tbody/tr[1]/td")).size());j++) {
    System.out.print(dr.findElement(By.xpath(" /html/body/div[3]/div[2]/fieldset[2]/div[1]/table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")).getText()+" || ");}
		System.out.println("");}
}

public void MouseHoverExample() throws InterruptedException
{
	JavascriptExecutor js=(JavascriptExecutor) dr;
	Thread.sleep(5000);
	js.executeScript("arguments[0].scrollIntoView()", dr.findElement(By.xpath("/html/body/div[4]/div/fieldset/legend")));
	
	System.out.println(dr.findElement(By.xpath("/html/body/div[4]/div/fieldset/legend")).getText());
	Assert.assertEquals(dr.findElement(By.xpath("/html/body/div[4]/div/fieldset/legend")).getText(), "Mouse Hover Example");
	Actions action=new Actions(dr);
	action.moveToElement(dr.findElement(By.id("mousehover"))).perform();
	action.moveToElement(dr.findElement(By.xpath("/html/body/div[4]/div/fieldset/div/div/a[1]"))).click().perform();
	System.out.println(dr.findElement(By.xpath("/html/body/h1")).isDisplayed());

	js.executeScript("arguments[0].scrollIntoView()", dr.findElement(By.xpath("/html/body/div[5]/fieldset/legend")));
	System.out.println(dr.switchTo().frame(dr.findElement(By.id("courses-iframe")))
			.findElement(By.id("showHeader")).isDisplayed());
}
}
