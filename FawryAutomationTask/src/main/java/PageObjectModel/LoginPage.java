package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By emailInput = By.cssSelector("input[type=\"email\"]");
    By continueButton = By.cssSelector("input[id=\"continue\"]");
    By passwordInput = By.cssSelector("input[type=\"password\"]");
    By signInButton = By.cssSelector("input[id=\"signInSubmit\"]");

    public LoginPage(WebDriver driver){this.driver=driver;}

    public LandingPage LoginUsingEmailOrNumber(String numberOrEmail,String password){
        driver.findElement(emailInput).sendKeys(numberOrEmail);
        driver.findElement(continueButton).click();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();

        return new LandingPage(driver);
    }



}
