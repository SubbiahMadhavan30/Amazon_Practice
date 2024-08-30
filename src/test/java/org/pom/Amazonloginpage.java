package org.pom;


import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonloginpage extends Baseclass {
public Amazonloginpage() {
PageFactory.initElements(driver, this);

}

@FindBy(xpath="//*[text()='Hello, sign in']")
private WebElement signin;

public WebElement getSignin() {
	return signin;
}

@FindBy(xpath="(//*[text()='Sign in'])[1]")
private WebElement sign;

public WebElement getSign() {
	return sign;
}
 @FindBy(xpath ="//*[@name='email']")
 private WebElement email;

public WebElement getEmail() {
	return email;
}
@FindBy(xpath="//*[@class='a-button-input']")
private WebElement emailcont;

public WebElement getEmailcont() {
	return emailcont;
}
@FindBy(xpath="//*[@id='ap_password']")
private WebElement password;

public WebElement getPassword() {
	return password;
}

@FindBy(xpath="//*[@id='signInSubmit']")
private WebElement passwordsignin;

public WebElement getPasswordsignin() {
	return passwordsignin;
}




@FindBy(xpath="//*[@id='twotabsearchtextbox']")
private WebElement amazonglobalsearchbar;

public WebElement getamazonglobalsearchbar() {
	return amazonglobalsearchbar;
}

//*[@id='nav-search-submit-button']
@FindBy(xpath="//*[@id='nav-search-submit-button']")
private WebElement searchicon;

public WebElement getsearchicon() {
	return searchicon;
}
//span[contains(text(),'JustHuman')]

@FindBy(xpath="//span[contains(text(),'JustHuman')]")
private WebElement searchproduct;

public WebElement getsearchproduct() {
	return searchproduct;
}


@FindBy(xpath="//input[@id='add-to-cart-button']")
private WebElement addcart;
public WebElement getaddcart() {
	return addcart;
}

@FindBy(xpath="//*[@name='proceedToRetailCheckout']")
private WebElement checkout;

public WebElement getcheckout() {
	return checkout;
	
	
	
}//*[@id='shipToThisAddressButton-announce']
@FindBy(xpath="//*[@data-testid='Address_selectShipToThisAddress']")
private WebElement usethisaddress;

public WebElement getusethisaddress() {
	return usethisaddress;
}
@FindBy(xpath="//*[@value='SelectableAddCreditCard']")
private WebElement creditcard;

public WebElement getcreditcard() {
	return creditcard;
}

@FindBy(xpath="//a[text()='Enter card details']")
private WebElement enterdetails;

public WebElement getenterdetails() {
	return enterdetails;
}
//*[@value='SelectableAddCreditCard']
//*[@name='addCreditCardNumber']
@FindBy(xpath="//*[@name='addCreditCardNumber']")
private WebElement addcreditnum;

public WebElement getaddcreditnum() {
	return addcreditnum;
}

@FindBy(xpath="//*[@id='orderSummaryPrimaryActionBtn-announce']")
private WebElement cash;

public WebElement getcash() {
	return cash;
}
//*[@data-cy='title-recipe']/child::h2/descendant::span[contains(text(),'BRITACEL HEALTHCARE')]
//*[@data-cy='title-recipe']/child::div/following-sibling::h2/descendant::span[contains(text(),'BRITACEL HEALTHCARE')]
//*[@id='orderSummaryPrimaryActionBtn-announce']
//*[@id="pp-QpYqdz-135"]
//*[@data-cy='title-recipe']/child::div/following-sibling::h2/descendant::span[contains(text(),'BRITACEL HEALTHCARE')]
}
