package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductToCart {
    WebDriver driver;
    Home testin;
    Search testin4;
    Cart testin5;
    SoftAssert softAssert;
    String price1;
    String price2;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        testin = new Home(driver);
        testin4 = new Search(driver);
        testin5 = new Cart(driver);
        softAssert = new SoftAssert();
    }
    @Test
    public void Testcase12(){
        testin.homePage();
        testin.atHome();
        testin4.clickProductsButton();
        price1 = testin4.getProductPrice(1);
        price2 = testin4.getProductPrice(2);
        testin4.clickAddToCart(1);
        testin4.clickContinueShopping();
        testin4.clickAddToCart(2);
        testin4.clickViewCart();
        softAssert.assertTrue(testin5.verifyAddedToCart(1));
        softAssert.assertTrue(testin5.verifyAddedToCart(2));
        softAssert.assertEquals(testin5.getProductPriceCart(1),price1);
        softAssert.assertEquals(testin5.getproductQuantity(1),"1");
        softAssert.assertEquals(testin5.getproductTotal(1),"Rs. 500");
        softAssert.assertEquals(testin5.getProductPriceCart(2),price2);
        softAssert.assertEquals(testin5.getproductQuantity(2),"1");
        softAssert.assertEquals(testin5.getproductTotal(2),"Rs. 400");
        softAssert.assertAll();
    }
}
