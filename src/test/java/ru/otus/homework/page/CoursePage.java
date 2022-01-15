package ru.otus.homework.page;

import org.openqa.selenium.*;
import org.testng.Assert;

public class CoursePage extends BasePage {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public void checkTitleEquals(String expected) {
            Assert.assertEquals(expected, driver.getTitle());
    }
}

