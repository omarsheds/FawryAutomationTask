package testcases;

import PageObjectModel.LandingPage;
import PageObjectModel.VideoGamesPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigUtils;

public class VideogamesListTest extends BaseTest {

    @Test
    public void videoGamesListOrderingFromHighToLowSuccessfully(){
        LandingPage lp = new LandingPage(driver);
        lp
                .clickOnLoginButton()
                .LoginUsingEmailOrNumber(ConfigUtils.getInstanceofConfigUtils().getEmailOrNumber(), ConfigUtils.getInstanceofConfigUtils().getPassword())
                .chooseAllVideoGamesFromAllDropdown()
                .clickOnFreeShippingCheckBox()
                .clickOnNewCondition()
                .selectFromSortingDropDownFromHighToLow();
        VideoGamesPage videoGamesPage = new VideoGamesPage(driver);
        Assert.assertEquals(videoGamesPage.isListSortedFromHighToLow(),"Price: High to Low");

    }
}