package Tests;


import Pages.AccountCreatedDeleted;
import Pages.Home;
import Pages.Signup;
import Pages.SignupLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.Objects;

public class RegisterUser {
    WebDriver driver ;
    Home testin;
    SignupLogin testin1;
    Signup testin2;
    AccountCreatedDeleted testin3;
    SoftAssert softAssert;

    @Test
    public void Testcase1() {
        driver = new ChromeDriver();
        testin = new Home(driver);
        testin1 = new SignupLogin(driver);
        testin2 = new Signup(driver);
        testin3 = new AccountCreatedDeleted(driver);
        softAssert = new SoftAssert();
        testin.homePage();
        softAssert.assertTrue(testin.atHome());
        testin.clickSL();
        testin1.atSignin();
        testin1.enterName("kool");
        testin1.enterSignEmail("kool@gmail.com");
        testin1.clickSignup();
        softAssert.assertTrue(testin2.atAccountInformation());
        testin2.chooseTitle("Male");
        testin2.enterPassword("kool");
        testin2.selectBirthDate("7","April","1998");
        testin2.clickNewsletter();
        testin2.clickReceiveOffers();
        testin2.enterFirstName("koolf");
        testin2.enterLastName("koolL");
        testin2.enterCompany("vois");
        testin2.enterAddress("NewCairo");
        testin2.enterAddress2("somewhere");
        testin2.selectCountry("Canada");
        testin2.enterState("State");
        testin2.enterCity("Toronto");
        testin2.enterZipcode("12345");
        testin2.enterMobileNum("+201115160217");
        testin2.clickCreateAccount();
        softAssert.assertTrue(testin3.atAccountCreated());
        testin3.clickContinue();
        softAssert.assertTrue((Objects.equals(testin.loggedUserName(), "kool")));
        testin.deleteAccount();
        softAssert.assertTrue(testin3.atAccountDeleted());
        testin3.clickContinue();
        softAssert.assertAll();
    }
}
