package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By changeAddressIcon = By.id("addressChangeLinkId");
    private By addNewAddress = By.id("add-new-address-popover-link");
    private By countryDropdown = By.xpath("//span[@id=\"address-ui-widgets-countryCode\"]//span");
    private By countrySelection = By.xpath("//a[contains(text(),'Brazil')]");
    private By fullNameElement = By.id("address-ui-widgets-enterAddressFullName");
    private By phoneNumberElement = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private By streetNameElement = By.id("address-ui-widgets-enterAddressLine1");
    private By buildingNameElement = By.id("address-ui-widgets-enter-building-name-or-number");
    private By cityElement = By.id("address-ui-widgets-enterAddressCity");
    private By districtElement = By.cssSelector("[id=\"address-ui-widgets-enterAddressDistrictOrCounty\"]");
    private By govElement = By.cssSelector("[id=\"address-ui-widgets-enterAddressStateOrRegion\"]");
    private By landmarkElement = By.id("address-ui-widgets-landmark");
    //    private By addAddressButton = By.id("address-ui-widgets-form-submit-button-announce");
    private By addAddressButton = By.xpath("//input[@class=\"a-button-input\" and @aria-labelledby=\"address-ui-widgets-form-submit-button-announce\"]");


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public CheckoutPage clickOnChangeAddress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(changeAddressIcon));
        driver.findElement(changeAddressIcon).click();
        return this;
    }

    public CheckoutPage clickOnAddNewAddress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addNewAddress));
        driver.findElement(addNewAddress).click();
        return this;
    }

//    public CheckoutPage clickOnCountryDropdown(){
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown));
//        driver.findElement(countryDropdown).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(countrySelection));
//        return this;
//    }

//    public CheckoutPage clickOnEgypt(){
//        driver.findElement(countrySelection).click();
//        return this;
//    }

    public CheckoutPage goToCheckoutPage(){
        WebElement cartElement = driver.findElement(By.id("nav-cart"));
        cartElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"a-button a-button-normal a-button-span12 a-button-primary\"]")));
        WebElement proceedToBuyElement = driver.findElement(By.xpath("//span[@class=\"a-button a-button-normal a-button-span12 a-button-primary\"]"));
        proceedToBuyElement.click();
        return this;
    }

    public CheckoutPage enterFullName(String fullName) {
        driver.findElement(fullNameElement).sendKeys(fullName);
        return this;
    }
    public CheckoutPage enterPhoneNumber(String phoneNumber){

        driver.findElement(phoneNumberElement).sendKeys(phoneNumber);
        return this;
    }

    public CheckoutPage enterStreetName(String streetName){

        driver.findElement(streetNameElement).sendKeys(streetName);
        return this;
    }

    public CheckoutPage enterBuildingNumber(String buildingName){
        driver.findElement(buildingNameElement).sendKeys(buildingName);
        return this;
    }

    public CheckoutPage enterCity (String city) {

        driver.findElement(cityElement).sendKeys(city);
        driver.findElement(districtElement).click();

        return this;
    }

    public CheckoutPage enterDistrict (String district)  {
        wait.until(ExpectedConditions.elementToBeClickable(districtElement));
        driver.findElement(districtElement).sendKeys(district);
        driver.findElement(govElement).click();
        return this;
    }
    public CheckoutPage enterGovernorate(String gov) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(govElement));
        driver.findElement(govElement).sendKeys(gov);
        driver.findElement(landmarkElement).click();
        return this;
    }

    public CheckoutPage enterNearestLandmark(String landmark){
        driver.findElement(landmarkElement).sendKeys(landmark);
        return this;
    }

    public void clickOnAddAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(addAddressButton));
        driver.findElement(addAddressButton).click();
    }






}
