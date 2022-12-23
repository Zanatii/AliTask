package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLogin {
    String url = "https://automationexercise.com/login";
    WebDriver driver;
    By newUSWord = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    By loginWord = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
    By nameField = By.xpath("//input[@data-qa='signup-name']");
    By emailSignField = By.xpath("//input[@data-qa='signup-email']");
    By emailLogField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By incorrectData = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
    By alreadyExist = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
    public SignupLogin( WebDriver driver) {
        this.driver = driver ;
    }
    public void sLPage (){driver.get(url);
    }
    public boolean atSignin (){
        return driver.findElement(newUSWord).isDisplayed();
    }
    public boolean atlogin (){
        return driver.findElement(loginWord).isDisplayed();
    }
    public void enterName(String nameSign){
        driver.findElement(nameField).sendKeys(nameSign);
    }
    public void enterSignEmail( String emailSign){
        driver.findElement(emailSignField).sendKeys(emailSign);
    }
    public void clickSignup(){
        driver.findElement(signupButton).click();
    }
    public void enterLoginEmail(String emailLogin){
        driver.findElement(emailLogField).sendKeys(emailLogin);
    }
    public void enterPassword( String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin (){
        driver.findElement(loginButton).click();
    }
    public String errorMessage(){
        return driver.findElement(incorrectData).getText();
    }
    public String errorMessage2(){
        return driver.findElement(alreadyExist).getText();
    }
}
