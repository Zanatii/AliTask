package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchProduct {
    WebDriver driver ;
    Home testin;
    Search testin4;
    SoftAssert softAssert;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        testin = new Home(driver);
        testin4 = new Search(driver);
        softAssert = new SoftAssert();
    }
    @Test
    public void l1Testcase9(){
        testin.homePage();
        testin4.clickProductsButton();
        softAssert.assertTrue(testin4.atProductsPage());
        testin4.allProducts();
        testin4.searchFor("dress");
        testin4.clickSearchButton();
        softAssert.assertTrue(testin4.atSearchProducts());
        System.out.println(testin4.verifyAllRelated());
        softAssert.assertTrue(testin4.verifyAllRelated());
        softAssert.assertAll();
    }
}
