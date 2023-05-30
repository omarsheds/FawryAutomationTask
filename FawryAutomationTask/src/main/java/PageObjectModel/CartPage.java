package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static PageObjectModel.VideoGamesPage.productNames;

public class CartPage {
    WebDriver driver;
    private By products = By.xpath("//div[@class=\"sc-item-content-group\"]//span[@class=\"a-truncate-cut\"]");

    public CartPage(WebDriver driver) {
        this.driver=driver;
    }

    public List<String> getProductsNamesInCart(){
        List<String> productNamesInCart = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(products);
        for (int i=0; i<productNames.size();i++){
            productNamesInCart.add(productElements.get(i).getText());
        }
        return productNamesInCart;
    }
}
