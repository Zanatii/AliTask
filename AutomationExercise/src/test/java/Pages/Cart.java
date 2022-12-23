package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    WebDriver driver;
    By productPriceCart;
    By productQuantity;
    By addedProduct;
    By productTotal;
    WebDriverWait webDriverWait;
    public Cart(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    public String getProductPriceCart(int i) {
        productPriceCart = By.xpath("(//td[@class='cart_price'])["+i+"]");
        return driver.findElement((productPriceCart)).getText();
    }
    public String getproductQuantity(int i) {
        productQuantity = By.xpath("(//td[@class='cart_quantity'])["+i+"]");
        return driver.findElement((productQuantity)).getText();
    }
    public String getproductTotal(int i) {
        productTotal = By.xpath("(//p[@class='cart_total_price'])["+i+"]");
        return driver.findElement((productTotal)).getText();
    }
    public boolean verifyAddedToCart(int i){
        addedProduct = By.xpath("//a[@href='/product_details/"+i+"']");
        return driver.findElement(addedProduct).isDisplayed();

    }



}
