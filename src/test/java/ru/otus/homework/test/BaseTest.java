package ru.otus.homework.test;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.otus.homework.driver.WebDriverFactory;
import ru.otus.homework.listener.MarkBeforeClickListener;

import java.time.Duration;

public class BaseTest {

    protected EventFiringWebDriver driver;

    protected WebDriverWait wait;

    protected Actions actions;

    protected String courses = System.getProperty("courses");


    @BeforeClass
    public void setUpDriver() throws InterruptedException {

        String browser = System.getProperty("browser");

        driver = new EventFiringWebDriver(WebDriverFactory.setupDriver(WebDriverFactory.DriverType.valueOf(browser)));
        driver.register(new MarkBeforeClickListener());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actions = new Actions(driver);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
