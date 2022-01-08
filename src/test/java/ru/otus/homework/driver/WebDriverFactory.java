package ru.otus.homework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WebDriverFactory {

    public static enum DriverType {
        CHROME,
        FIREFOX,
        OPERA
    }

    public static WebDriver setupDriver(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) WebDriverConfig.getOptions(new ChromeOptions()));
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) WebDriverConfig.getOptions(new FirefoxOptions()));
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver((OperaOptions) WebDriverConfig.getOptions(new OperaOptions()));
            default:
                throw new WebDriverException("тип драйвера не верный");
        }
    }
}
