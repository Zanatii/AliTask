package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
public class Search {
    WebDriver driver;
    By productsButton = By.xpath("//a[@href='/products']");
    By productsButtonClicked = By.xpath("//a[@href='/products'][contains(@style,'color: orange')]");
    By searchField = By.id("search_product");
    By searchButton = By.id("submit_search");
    By searchProductsWord = By.xpath("//h2[@class=\"title text-center\"]");
    By productName;
    By productPrice;
    ArrayList<String> allProducts = new ArrayList<String>();
    ArrayList<String> searchResult = new ArrayList<String>();
    String searchedProduct;
    By addToCartButton;
    By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    By viewCartButton = By.xpath("(//a[@href=\"/view_cart\"])[2]");
    WebDriverWait webDriverWait;
    Actions action;
    public Search(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        action = new Actions(driver);
    }
    public void clickProductsButton(){
        driver.findElement(productsButton).click();
    }
    public boolean atProductsPage (){
        return driver.findElement(productsButtonClicked).isDisplayed();
    }
    public void clickAddToCart(int i){
        addToCartButton = By.xpath("//a[@data-product-id='"+i+"']");
        action.moveToElement(driver.findElement(addToCartButton)).click();
        driver.findElement(addToCartButton).click();
    }
    public void clickContinueShopping(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        driver.findElement(continueShoppingButton).click();
    }
    public void clickViewCart(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        driver.findElement(viewCartButton).click();
    }
    public void searchFor (String product){
        driver.findElement(searchField).sendKeys(product);
        searchedProduct = product;
    }
    public void clickSearchButton (){
        driver.findElement(searchButton).click();
        for (int i =1 ; i<=9 ; i++) // hard coded to test for the 9 dresses search result (cause the isDisplayed() isn't working in the if condition).
        {
            productName = By.xpath("(//div[@class='productinfo text-center'])["+i+"]/p");
            searchResult.add(productInfo(productName));
        }
    }
    public boolean atSearchProducts (){
        return driver.findElement(searchProductsWord).isDisplayed();
    }
    public String productInfo (By productID){
        return driver.findElement((productID)).getText();
    }
    public String getProductPrice(int i) {
        productPrice = By.xpath("(//div[@class='productinfo text-center'])["+i+"]/h2");
        return driver.findElement((productPrice)).getText();
    }
    public void allProducts(){
        for (int i =1 ; i<=34 ; i++)
        {
            productName = By.xpath("(//div[@class='productinfo text-center'])["+i+"]/p");
            if (driver.findElement(productName).isDisplayed()) {
                allProducts.add(productInfo(productName));
            }
            else {continue;
            }
        }
    }
    public boolean verifyAllRelated () {
        for (int i = 0; i <= (allProducts.size()-1); i++) {
            if (allProducts.get(i).contains(searchedProduct)) {
                for (int j = 0; j <= (searchResult.size()-1); j++) {
                    if (searchResult.get(j).contains(allProducts.get(i))) {//continue;
                    }
                    else {return false;}
                }
            }
        }
        return true;}
}
