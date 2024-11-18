package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.pageFactoryLocators.HomePageLocators;

import java.time.Duration;

public class BankManagerLoginTest extends TestBase {

    private HomePageLocators homePageLocators ;

    @BeforeClass
    public void initializePageObjects(){
        homePageLocators = new HomePageLocators(webDriver);
    }

    @Test
    public void bankingManagerLoginTest(){

        System.out.println("Webdriver initialized: " + webDriver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        homePageLocators.bankManagerLogin.click();


        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement managerLoginButton = wait.until(ExpectedConditions.elementToBeClickable(homePageLocators.bankManagerLogin));
        managerLoginButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        assert homePageLocators.addCustomerButton.isDisplayed();
        homePageLocators.addCustomerButton.click();
        logger.debug("Login successfully executed...");
    }
}
