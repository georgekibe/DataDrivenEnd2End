package utilities.pageFactoryLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocators {

    private WebDriver webDriver;

    @FindBy(xpath = "//button[@ng-click='manager()']")
    public WebElement bankManagerLogin;

    @FindBy(css = "button[ng-click='customer()']")
    public WebElement customerLogin;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    public WebElement addCustomerButton;


    public HomePageLocators(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        System.out.println("Driver passed to HomePageLocators: " + webDriver);
    }

}
