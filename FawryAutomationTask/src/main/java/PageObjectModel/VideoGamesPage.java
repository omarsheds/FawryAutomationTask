package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VideoGamesPage {

    WebDriver driver;
    private By freeShippingCheckBox = By.xpath("//div[@class=\"a-checkbox a-checkbox-fancy aok-float-left apb-browse-refinements-checkbox\"]//i[@class=\"a-icon a-icon-checkbox\"]");
    private By newCondition = By.xpath("//span[text()=\"New\"]");
    private By sortList = By.xpath("//span[@class=\"a-button-text a-declarative\"]/ancestor::span[@aria-label=\"Sort by:\"]");
    private By highToLowSelection = By.xpath("//a[text()=\"Price: High to Low\"]");
    private By inventoryItemsPrice= By.xpath("//span[@class=\"a-price-whole\"]");

    private By AddToCartButton = By.id("add-to-cart-button");
    private By noThanksButton = By.xpath("(//div[@class=\"a-button-stack\"]//span[text()=\" No Thanks \"]/preceding-sibling::input[@type=\"submit\"])[1]");
    private By itemAddedLabel = By.xpath("//input[contains(@value,\"Proceed to checkout\")]");
    private By cartIcon = By.cssSelector("[href=\"https://www.amazon.eg/-/en/gp/cart/view.html?ref_=nav_cart\"]");
    private By productTitle = By.xpath("//span[@id=\"productTitle\"]");

    private By sortingType = By.xpath("//span[text()=\"Price: High to Low\"]");

    private WebDriverWait wait;

    private StringBuffer sb;
    public static List<String> productNames;


    public VideoGamesPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public VideoGamesPage clickOnFreeShippingCheckBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(freeShippingCheckBox));
        driver.findElement(freeShippingCheckBox).click();
        return this;
    }

    public VideoGamesPage clickOnNewCondition(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCondition));
        driver.findElement(newCondition).click();
        return this;
    }

    private WebElement findSortingDropdownElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortList));
        return driver.findElement(sortList);
    }

    public VideoGamesPage selectFromSortingDropDownFromHighToLow() {
        findSortingDropdownElement().click();
        driver.findElement(highToLowSelection).click();
        return this;
    }

    public By getFreeShippingCheckBox(){
       return freeShippingCheckBox;
    }

    public VideoGamesPage clickItemLessFifteen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"a-price-whole\"]")));
        productNames = new ArrayList<>();
        List<WebElement> priceElements = driver.findElements(inventoryItemsPrice);
        for(int i=0 ; i<priceElements.size();i++){
            priceElements = driver.findElements(inventoryItemsPrice);
            int price = Integer.parseInt(priceElements.get(i).getText().replace(",", ""));
            if (price < 15000) {
                WebElement temp =priceElements.get(i);
                wait.until(ExpectedConditions.visibilityOf(temp));
                temp.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
                productNames.add(driver.findElement(productTitle).getText());
                wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartButton));
                driver.findElement(AddToCartButton).click();
                try{
                new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(noThanksButton));
                driver.findElement(noThanksButton).click();
                }catch(Exception e){

                }
                wait.until(ExpectedConditions.visibilityOfElementLocated(itemAddedLabel));
                driver.navigate().to("https://www.amazon.eg/s?i=videogames&bbn=18022560031&rh=n%3A18022560031%2Cp_n_free_shipping_eligible%3A21909080031%2Cp_n_condition-type%3A28071525031&s=price-desc-rank&dc&language=en&ds=v1%3A37Ugb%2FcC1AU8LVGV%2BwNCMqWpl2zQMa0oCF9DOW3kGTs&qid=1685394417&rnid=28071523031&ref=sr_st_price-desc-rank");


            }
        }
        return this;
    }

    public CartPage goToCart(){
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }

    public String  isListSortedFromHighToLow(){
        WebElement element = driver.findElement(sortingType);
        return element.getText();
    }

}
