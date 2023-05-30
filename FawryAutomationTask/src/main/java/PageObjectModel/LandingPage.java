package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    private WebDriver driver;
    private By allDropdown = By.id("nav-hamburger-menu");
    private By loginButton = By.linkText("Sign in");
    private By seeAllButton = By.xpath("//div[text()=\"see all\"]");
    private By gamesOption = By.xpath("//div[text()=\"Video Games\"]/parent::a");
    private By allVideoGamesOption = By.xpath("//a[text()=\"All Video Games\"]");
    private By helloSignInLabel = By.id("nav-link-accountList-nav-line-1");

    private WebDriverWait wait;

    public LandingPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginPage clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public VideoGamesPage chooseAllVideoGamesFromAllDropdown(){
        driver.findElement(allDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllButton));
        driver.findElement(seeAllButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(gamesOption));
        driver.findElement(gamesOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(allVideoGamesOption));
        driver.findElement(allVideoGamesOption).click();
        return new VideoGamesPage(driver);
    }

    public String HelloText(){
        WebElement element = driver.findElement(helloSignInLabel);
        return element.getText();
    }
}
