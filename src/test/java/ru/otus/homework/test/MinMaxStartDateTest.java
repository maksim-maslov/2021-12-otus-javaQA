package ru.otus.homework.test;

import org.testng.annotations.Test;
import ru.otus.homework.page.MainPage;

public class MinMaxStartDateTest extends BaseTest {

    @Test
    public void startDateTest() {

        String order = System.getProperty("order");

        MainPage mainPage = new MainPage(driver);

        mainPage.goTo()
            .moveToElementAndClickOnCourse(
                actions,
                mainPage.getCourseByMinMaxDate(
                    courses,
                    order
                )
            );

    }
}
