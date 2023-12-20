package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import base.TestBase_old;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;

public class PlaceOrderTest{
	
	WebDriver driver;;
	HomePage homePage;
	SearchResultPage resultPage;
	ShoppingCartPage cartPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		homePage = new HomePage(driver);
		resultPage = new SearchResultPage(driver);
		cartPage = new ShoppingCartPage(driver);
	}
	@BeforeMethod
	public void setup() {
		TestBase.openUrl("https://danube-webshop.herokuapp.com/");
	}
  @Test
  public void addItemTest() {
	   homePage.searchItem("Parry Hotter");
	  resultPage.viewItemDetail();
	  resultPage.addToCart();
	 }
  
  @Test
  public void checkoutItems() {
	   boolean isAdded = cartPage.isItemAdded();
	  Assert.assertTrue(isAdded);
	  cartPage.addCoupon();
	  cartPage.doCheckout();
	  
	}
  
}
