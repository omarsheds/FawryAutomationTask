package testcases;

import PageObjectModel.CheckoutPage;
import PageObjectModel.LandingPage;
import base.BaseTest;
import org.testng.annotations.Test;
import utils.ConfigUtils;

public class CheckoutTest extends BaseTest {

    @Test
    public void addAddress() throws InterruptedException {
        LandingPage lp = new LandingPage(driver);
        lp
                .clickOnLoginButton()
                .LoginUsingEmailOrNumber(ConfigUtils.getInstanceofConfigUtils().getEmailOrNumber(),ConfigUtils.getInstanceofConfigUtils().getPassword());

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage
                .goToCheckoutPage()
                .clickOnChangeAddress()
                .clickOnAddNewAddress()
                .enterFullName(ConfigUtils.getInstanceofConfigUtils().fullName())
                .enterPhoneNumber(ConfigUtils.getInstanceofConfigUtils().phoneNumber())
                .enterStreetName(ConfigUtils.getInstanceofConfigUtils().streetName())
                .enterBuildingNumber(ConfigUtils.getInstanceofConfigUtils().buildingNumber())
                .enterCity(ConfigUtils.getInstanceofConfigUtils().city())
                .enterDistrict(ConfigUtils.getInstanceofConfigUtils().district())
                .enterGovernorate("Mahalla")
                .enterNearestLandmark(ConfigUtils.getInstanceofConfigUtils().landmark())
                .clickOnAddAddress();


    }

}

