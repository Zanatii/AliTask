package Tests;

import Pages.Home;
import Pages.SignupLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginWithInvalidData {
    WebDriver driver;
    Home testin;
    SignupLogin testin1;
    SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        testin = new Home(driver);
        testin1 = new SignupLogin(driver);
        softAssert = new SoftAssert();
    }
    @Test
    public void Testcase3(){
        testin.homePage();
        testin.atHome();
        testin.clickSL();
        softAssert.assertTrue(testin1.atlogin());
        testin1.enterLoginEmail("wrongemail@live.com");
        testin1.enterPassword("also wrong password");
        testin1.clickLogin();
        softAssert.assertTrue(testin1.errorMessage().contains("Your email or password is incorrect!"));
        softAssert.assertAll();
    }
}
