package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class BuyItem {
    WebDriver driver ;
    private static By inventoryItemsPrice=new By.ByClassName("a-price-whole");

    public BuyItem(WebDriver driver){this.driver=driver;}

    public  void clickItemLessFifteen() {
        List<WebElement> priceElements = driver.findElements(inventoryItemsPrice);
        for (WebElement element : priceElements) {
            int price = Integer.parseInt(element.getText().replace(",", ""));
            if (price < 15000) {
                element.click();
            }
        }
    }
}
