package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedDeleted {
    WebDriver driver;
    By accountCreatedWord = By.xpath("//h2[@data-qa='account-created']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");
    By accountDeletedWord = By.xpath("//h2[@data-qa='account-deleted']");
    public AccountCreatedDeleted(WebDriver driver){
        this.driver = driver;
    }
    public boolean atAccountCreated(){
        return driver.findElement(accountCreatedWord).isDisplayed();
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }
    public boolean atAccountDeleted(){
        return driver.findElement(accountDeletedWord).isDisplayed();
    }
}
