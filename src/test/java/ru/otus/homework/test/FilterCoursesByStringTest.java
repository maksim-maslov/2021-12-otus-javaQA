package ru.otus.homework.test;

import org.testng.annotations.Test;
import ru.otus.homework.page.MainPage;
import ru.otus.homework.utils.NoFindCourseException;

public class FilterCoursesByStringTest extends BaseTest {

    @Test
    public void filterCoursesTest() {

        String course = System.getProperty("course");

        MainPage mainPage = new MainPage(driver);

        try {

            mainPage.goTo()
                .moveToElementAndClickOnCourse(
                    actions,
                    mainPage.filterCoursesByString(
                        courses,
                        course
                    )
                )
                .checkTitleEquals(course);

        } catch (NoFindCourseException e) {
            e.printException(course);
            e.printStackTrace();
        }

    }
}
