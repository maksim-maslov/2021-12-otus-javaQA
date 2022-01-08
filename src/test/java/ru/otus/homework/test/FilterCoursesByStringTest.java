package ru.otus.homework.test;

import org.testng.annotations.Test;
import ru.otus.homework.page.MainPage;

public class FilterCoursesByStringTest extends BaseTest {

    @Test
    public void filterCoursesTest() throws InterruptedException {

        String course = System.getProperty("course");

        MainPage mainPage = new MainPage(driver);

        mainPage.goTo()
            .moveToElementAndClickOnCourse(
                actions,
                mainPage.filterCoursesByString(
                    mainPage.courses,
                    course
                )
            );

        Thread.sleep(5000);
    }
}
