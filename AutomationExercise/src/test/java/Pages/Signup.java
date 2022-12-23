package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Signup {
    String url = "https://automationexercise.com/signup";
    WebDriver driver;
    By enterAIWord = By.xpath("//*[@id='form']/div/div/div/div/h2/b");
    By titleFieldMale = By.id("id_gender1"); // By.xpath("//input[@id='id_gender1']");
    By titleFieldFemale = By.id("id_gender2");
    By passwordField = By.xpath("//input[@data-qa='password']"); // By.id("password")
    Select selector;
    By dayOfBirthField = By.id("days");
    By monthOfBirthField = By.id("months");
    By yearOfBirthField = By.id("years");
    By newsletterField = By.id("newsletter");
    By receiveOffersField = By.id("optin");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By companyField = By.id("company");
    By addressField = By.id("address1");
    By address2Field = By.id("address2");
    By countryField = By.id("country");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumField = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    public Signup( WebDriver driver) {
        this.driver = driver ;
    }
    public void signupPage (){driver.get(url);
    }
    public boolean atAccountInformation (){
        return driver.findElement(enterAIWord).isDisplayed();
    }
    public void chooseTitle(String gender){
        if (gender == "Male"){
            driver.findElement(titleFieldMale).click();
        }
        else { driver.findElement(titleFieldFemale).click();}
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void selectBirthDate (String day, String month, String year){
        selector = new Select(driver.findElement(dayOfBirthField));
        selector.selectByVisibleText(day);
        selector = new Select(driver.findElement(monthOfBirthField));
        selector.selectByVisibleText(month);
        selector = new Select(driver.findElement(yearOfBirthField));
        selector.selectByVisibleText(year);
    }
    public void clickNewsletter (){
        driver.findElement(newsletterField).click();
    }
    public void clickReceiveOffers(){
        driver.findElement(receiveOffersField).click();
    }
    public void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void enterCompany(String company){
        driver.findElement(companyField).sendKeys(company);
    }
    public void enterAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void enterAddress2(String address2){
        driver.findElement(address2Field).sendKeys(address2);
    }
    public void selectCountry(String country){
        selector = new Select(driver.findElement(countryField));
        selector.selectByVisibleText(country);
    }
    public void enterState(String state){
        driver.findElement(stateField).sendKeys(state);
    }
    public void enterCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void enterZipcode(String zipcode){
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }
    public void enterMobileNum(String mobileNum){
        driver.findElement(mobileNumField).sendKeys(mobileNum);
    }
    public void clickCreateAccount(){
        driver.findElement(createAccountButton).click();
    }


}
