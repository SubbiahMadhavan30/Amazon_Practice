package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	public static WebDriver driver;
	public static WebElement element;
	public static WebDriverWait waits;
	public static Workbook book;
	public static FileInputStream fi;

	// To Launch Browser
	public static void launchbrowser(String browsertype) {
		if (browsertype.equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Launch");
		} else if (browsertype.equals("edge")) {
			driver = new EdgeDriver();
			System.out.println("Edge Browser launch");

		} else {
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser launch");
		}

	}

	
	public static void launchurl(String url) {
		driver.get(url);

	}


	public static void maximize() {
		driver.manage().window().maximize();

	}

	public static void click(WebElement element) {
		element.click();

	}

	public static void Mousehover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static void applywaitsToAllElements() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void webdriverwaits(String wait, WebElement Element, long timeoutsecond) {
		if (wait.equals("visibility")) {

			waits = new WebDriverWait(driver, Duration.ofSeconds(timeoutsecond));
			waits.until(ExpectedConditions.visibilityOf(Element));

		} else if (wait.equals("invisibility")) {

			waits = new WebDriverWait(driver, Duration.ofSeconds(timeoutsecond));
			waits.until(ExpectedConditions.invisibilityOf(Element));
		} else if (wait.equals("clickable")) {

			waits = new WebDriverWait(driver, Duration.ofSeconds(timeoutsecond));
			waits.until(ExpectedConditions.elementToBeClickable(Element));
		}

	}

	
	public static void sendvalue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void windowshandle() {
		String parent = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();

		for (String windows : allwindows) {

			if (!parent.equals(windows)) {
				driver.switchTo().window(windows);
			}

		}

		/*
		 * List<String> li = new ArrayList<String>(); li.addAll(childwindow);
		 * driver.switchTo().window(li.get(1));
		 */

	}

	public static String readDataFromExcelcom(String filename, String sheetname, int row, int cell) throws Throwable {
// File f =new File(System.getProperty("user.dir")+"/Files/"+filename+".xlsx");

		java.io.File f = new File(System.getProperty("user.dir") + "/Files/" + filename + ".xlsx");
//			fi = new FileInputStream(f);
//			book = new XSSFWorkbook(fi);
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
		}
		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {
		}
		Sheet sheet = book.getSheet(sheetname);
		Row row2 = sheet.getRow(row);
		Cell cell2 = row2.getCell(cell);
		String cellValue = "";
		if (cell2 != null) {
			switch (cell2.getCellType()) {
			case STRING:
				cellValue = cell2.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell2)) {
					Date date = (Date) cell2.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					cellValue = dateFormat.format(date);
				} else {
					double numericValue = cell2.getNumericCellValue();
					// Format the numeric value to ensure it displays two decimal places
					DecimalFormat df = new DecimalFormat("0.00");
					cellValue = df.format(numericValue);
				}
				break;
			case BOOLEAN:
				cellValue = String.valueOf(cell2.getBooleanCellValue());
				break;
			case FORMULA:
				// Evaluate the formula and get the resulting cell value
				FormulaEvaluator evaluator = book.getCreationHelper().createFormulaEvaluator();
				CellValue evaluatedValue = evaluator.evaluate(cell2);
				switch (evaluatedValue.getCellType()) {
				case STRING:
					cellValue = evaluatedValue.getStringValue();
					break;
				case NUMERIC:
					double numericValue = evaluatedValue.getNumberValue();
					DecimalFormat df = new DecimalFormat("0.00");
					cellValue = df.format(numericValue);
					break;
				case BOOLEAN:
					cellValue = String.valueOf(evaluatedValue.getBooleanValue());
					break;
				default:
					cellValue = "Unsupported cell type";
					break;
				}
				break;
			case BLANK:
				cellValue = "";
				break;
			default:
				cellValue = "Unsupported cell type";
				break;
			}
		}

		return cellValue;
	}
}
