package testcases;

import PageObjectModel.LandingPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigUtils;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccessfully() throws InterruptedException {
        LandingPage lp = new LandingPage(driver);
        lp
                .clickOnLoginButton()
                .LoginUsingEmailOrNumber(ConfigUtils.getInstanceofConfigUtils().getEmailOrNumber(),ConfigUtils.getInstanceofConfigUtils().getPassword());

        Assert.assertNotEquals(lp.HelloText(),"Hello, sign in");
    }
}
