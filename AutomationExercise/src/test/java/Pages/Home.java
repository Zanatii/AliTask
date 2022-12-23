package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Home {

    String url = "https://automationexercise.com/";
    WebDriver driver;
    By homeButton = By.xpath("//a[@href='/'][contains(@style,'color: orange')]");
    By sLButton = By.xpath("//a[@href='/login']");
    By loggedUser = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");
    By deleteButton = By.xpath("//a[@href='/delete_account']");
    By logoutButton = By.xpath("//a[@href='/logout']");
    public Home( WebDriver driver) {
        this.driver = driver ;
    }
    public void homePage (){
        driver.get(url);
    }
    public boolean atHome (){
        return driver.findElement(homeButton).isDisplayed();
    }
    public void clickSL (){
        driver.findElement(sLButton).click();
    }
    public String loggedUserName(){
        return driver.findElement(loggedUser).getText();
    }
    public void deleteAccount(){
        driver.findElement(deleteButton).click();
    }
    public void clickLogout(){
        driver.findElement(logoutButton).click();
    }
}
