package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;
import utilities.pageFactoryLocators.HomePageLocators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver webDriver;
    public static Logger logger = Logger.getLogger(TestBase.class);
    public static Properties config = new Properties();
    public static FileInputStream fileInputStream;

    public HomePageLocators homePageLocators;


    @BeforeSuite
    public void setUp() {

        logger.debug("Test execution starting !!!");

        if (webDriver == null) {

            try {
                fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                config.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            if (config.getProperty("browser").equalsIgnoreCase("chrome")) {

                webDriver = new ChromeDriver();
            } else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
                webDriver = new FirefoxDriver();
            } else if (config.getProperty("browser").equalsIgnoreCase("edge")) {
                webDriver = new EdgeDriver();
            }

        }

        webDriver.get(config.getProperty("siteurl"));
        logger.debug("Navigated to: " + config.getProperty("siteurl"));

        webDriver.manage().window().maximize();

        initializePageObjects();


    }

    public void initializePageObjects() {
        homePageLocators = new HomePageLocators(webDriver);
        PageFactory.initElements(webDriver, this);
        System.out.println("Driver passed to HomePageLocators: " + webDriver);
    }


    @AfterSuite
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }

        logger.debug("Test execution completed !!!");
    }


}
