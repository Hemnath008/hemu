package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert a1;
	public static JavascriptExecutor js;
	public static Select s;

//1
	public static void toLaunchBroswer() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

//2
	public static void toLoadUrl(String url) {
		driver.get(url);

	}

//3
	public static void toFill(WebElement element, String text) {
		element.sendKeys(text);
	}

//4
	public static void toCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

//5
	public static void toMaximize() {
		driver.manage().window().maximize();

	}

//6
	public static void toTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

//7
	public static void toClick(WebElement element) {
		element.click();
	}

//8
	public static void toQuit() {
		driver.quit();
	}

//9   Actions
	public static void toPerformMoveToElement(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

//10	
	public static void toPerformDragAndDrop(WebElement source, WebElement target) {
		a = new Actions(driver);
		a.dragAndDrop(source, target).perform();

	}

//11	
	public static void toPerformDoubleClick(WebElement Element) {
		a = new Actions(driver);
		a.doubleClick(Element).perform();
	}

//12
	public static void toPerformContextClick(WebElement Element) {
		a = new Actions(driver);
		a.contextClick(Element).perform();
	}

//13   Robots
	public static void ToPressEnterKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

//14 
	public static void ToPressAltKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_ALT);
//15
	}

	public static void ToPressTabKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

//16
	public static void ToCopyText() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);

	}

//17
	public static void ToCutText() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);

	}

//18
	public static void ToSelectAllText() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);

	}

//19
	public static void ToPasteText() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

//20 Alerts
	public static void ToSwitchAlerts() {
		a1 = driver.switchTo().alert();

	}

//21 
	public static void toAcceptAlert() {
		a1.accept();
	}

// 22
	public static void toDismissAlert() {
		a1.dismiss();
	}

//23
	public static void toSendKeysAlert(String text) {
		a1.sendKeys(text);
	}

//24
	public static void toGetTextAlert() {
		String text = a1.getText();
		System.out.println(text);
	}

//25 screenshot
	public static void toScreenShot(String saveLocation) throws IOException {
		TakesScreenshot TS = (TakesScreenshot) driver;
		File ss = TS.getScreenshotAs(OutputType.FILE);
		File sh = new File(saveLocation);
		FileUtils.copyFile(ss, sh);

	}

//26 JavaScriptExecutor
	public static void ToJavaScript(String value, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript(value, element);
	}

//27 Frames
	public static void ToFrameSwitchUsingIndex(int indexValue) {
		driver.switchTo().frame(indexValue);

	}

//28
	public static void ToFrameSwitchUsingName(String nameOrId) {
		driver.switchTo().frame(nameOrId);

	}

//28
	public static void ToFrameSwitchUsingWebElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}

//29
	public static void ToFrameSwitchParent() {
		driver.switchTo().parentFrame();
	}

//30
	public static void ToFrameSwitchToMainHtml() {
		driver.switchTo().defaultContent();
	}

//31 Windows Handling
	public static void ToWindowSwitchUrl(String url) {
		driver.switchTo().window(url);

	}

//32
	public static void ToWindowSwitchTitle(String title) {
		driver.switchTo().window(title);

	}

//33
	public static void ToWindowSwitchId(String WindowId) {
		driver.switchTo().window(WindowId);

	}

//34
	public static void ToWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}

//35
	public static void ToWindowHandles(int IndexNo) {
		Set<String> Tabs = driver.getWindowHandles();
		List<String> ls = new ArrayList();

		ls.addAll(Tabs);
		driver.switchTo().window(ls.get(IndexNo));

		System.out.println(ls.get(IndexNo));

	}

//36 DropDown
	public static void ToDropDownByValue(WebElement Webelement, String value) {
		s = new Select(Webelement);
		s.selectByValue(value);

	}

//37
	public static void ToDropDownByVisibleText(WebElement Webelement, String text) {
		s = new Select(Webelement);
		s.selectByVisibleText(text);

	}

//38
	public static void ToDropDownByIndex(WebElement Webelement, int index) {
		s = new Select(Webelement);
		s.selectByIndex(index);
	}

//39
	public static void ToDropDownDeseletByIndex(WebElement Webelement, int index) {
		s = new Select(Webelement);
		s.deselectByIndex(index);
	}

//40
	public static void ToDropDownDeselectByVisibleText(WebElement Webelement, String text) {
		s = new Select(Webelement);
		s.deselectByVisibleText(text);
	}

//41
	public static void ToDropDownDeselectByValue(WebElement Webelement, String value) {
		s = new Select(Webelement);
		s.deselectByValue(value);
	}

//42
	public static void ToDropDownByDeselectAll(WebElement Webelement) {
		s = new Select(Webelement);
		s.deselectAll();
	}

//43
	public static String toReadExcel(int rowNo, int cellNo, String sheetName) throws IOException {
		File f = new File("C:\\Users\\hemna\\eclipse-workspace\\MavenFBCucum\\Excels\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sh = book.getSheet(sheetName);

		Row r = sh.getRow(rowNo);

		Cell c = r.getCell(cellNo);
		int cellType = c.getCellType();
		String value = "";
		if (cellType == 1) {
			value = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yyyy");
			value = sim.format(dateCellValue);

		} else {
			double numericCellValue = c.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);

		}
		return value;

	}
public static String toGetAttribute(WebElement element) {
	String attribute = element.getAttribute("value");
	return attribute;
	

}
}

     

