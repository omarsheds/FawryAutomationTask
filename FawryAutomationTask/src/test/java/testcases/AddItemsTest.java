package testcases;

import PageObjectModel.LandingPage;
import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ConfigUtils;

import java.util.List;

import static PageObjectModel.VideoGamesPage.productNames;

public class AddItemsTest extends BaseTest {


    @Test
    public void addItemsBelow15kAndCheckTheyExistInCart() throws InterruptedException {

        driver.get("https://www.amazon.eg/?language=en_AE");
        driver.manage().window().maximize();
        LandingPage lp = new LandingPage(driver);
        SoftAssert soft = new SoftAssert();


        List<String> productsInCart = lp.clickOnLoginButton()
                .LoginUsingEmailOrNumber(ConfigUtils.getInstanceofConfigUtils().getEmailOrNumber(),ConfigUtils.getInstanceofConfigUtils().getPassword())
                .chooseAllVideoGamesFromAllDropdown()
                .clickOnFreeShippingCheckBox()
                .clickOnNewCondition()
                .selectFromSortingDropDownFromHighToLow()
                .clickItemLessFifteen().goToCart().getProductsNamesInCart();

        for(int i = 0 ; i< productNames.size();i++){
            soft.assertEquals(productNames.get(i),productsInCart.get(productNames.size()-1-i),"Not the right Product");
        }
        soft.assertAll();
    }
}
