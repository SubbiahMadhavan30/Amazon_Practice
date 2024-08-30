package org.amazon;

import org.baseclass.Baseclass;
import org.pom.Amazonloginpage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assessment extends Baseclass {
	public static Amazonloginpage p;

	@BeforeClass
	public static void amazonHomePage() throws Throwable {
		launchbrowser("chrome");
		maximize();
		launchurl(readDataFromExcelcom("Amazon", "Sheet1", 0, 1));

	}

	@Test
	public void loginPage() throws Throwable {
		p = new Amazonloginpage();
		webdriverwaits("clickable", p.getSignin(), 40);
		Mousehover(p.getSignin());
		webdriverwaits("clickable", p.getSign(), 10);
		click(p.getSign());
		webdriverwaits("clickable", p.getEmail(), 10);
		sendvalue(p.getEmail(), readDataFromExcelcom("Amazon", "Sheet1", 1, 1));
		Thread.sleep(2000);
		click(p.getEmailcont());
		webdriverwaits("clickable", p.getPassword(), 10);
		sendvalue(p.getPassword(), readDataFromExcelcom("Amazon", "Sheet1", 2, 1));
		click(p.getPasswordsignin());

	}

	@Test
	public void searchPage() throws Throwable {
		p = new Amazonloginpage();
		webdriverwaits("clickable", p.getamazonglobalsearchbar(), 40);
		sendvalue(p.getamazonglobalsearchbar(), readDataFromExcelcom("Amazon", "Sheet1", 3, 1));
		click(p.getsearchicon());
		webdriverwaits("clickable", p.getsearchproduct(), 10);
		click(p.getsearchproduct());

	}

	@Test(dependsOnMethods = "searchPage")
	public void checkoutPage() throws Throwable {
	
		windowshandle();
		click(p.getaddcart());
		click(p.getcheckout());
		webdriverwaits("clickable", p.getusethisaddress(), 20);
		click(p.getusethisaddress());
		Thread.sleep(2000);
		webdriverwaits("clickable", p.getcreditcard(), 20);
		click(p.getcreditcard());

	}

	@AfterClass
	public void browserclose() {
		driver.quit();;
	}

}
