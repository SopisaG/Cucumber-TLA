package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverUtils {
    //singleton WebDriver
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if(driver == null)
            initializeDriver();
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void closeDriver() {
        if(driver != null) {
            driver.close();
            driver = null;
        }
    }

    private static void initializeDriver(){
        if(ConfigReader.readProperty("runInSaucelabs").equals("true")){
            initializeRemoteDriver();
        }else{
            initializeLocalDriver();
        }
    }


    private static void initializeLocalDriver() {
        switch (ConfigReader.readProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    private final static String browserType = ConfigReader.readProperty("browser");
    private final static String browserVersion = ConfigReader.readProperty(("browserVersion"));
    private final static String os = ConfigReader.readProperty("operatingSystem");
    private final static String saucelabsURL = "https://oauth-sopisa.pk-10f65:16dc9b33-69d4-4f19-8ce2-f39b502297c5@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    private static WebDriver initializeRemoteDriver(){

        try {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("browserName",browserType);
            capabilities.setCapability("version", ConfigReader.readProperty(browserVersion));
            capabilities.setCapability("platform", ConfigReader.readProperty(os));
            driver = new RemoteWebDriver(new URL(saucelabsURL), capabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }
}
