package ru.otus.homework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPage extends BasePage {

    private final String URL = "https://otus.ru/";

    @FindBy(xpath = "//a[contains(@class, 'js-stats lessons__new-item lessons__new-item_hovered')]")
    public List<WebElement> popular;

    @FindBy(xpath = "//a[contains(@class, 'lessons__new-item lessons__new-item_big lessons__new-item_hovered')]")
    public List<WebElement> specializations;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goTo() {
        driver.get(URL);
        return this;
    }


    public CoursePage moveToElementAndClickOnCourse(Actions actions, WebElement element) {
        actions.moveToElement(element).pause(3000).build().perform();
        element.click();
        return new CoursePage(driver);
    }


    public WebElement filterCoursesByString(String courses, String searchText) {

        List<WebElement> webElements;
        String xpath;

        if (courses.equals("Популярные курсы")) {
            webElements = popular;
            xpath = ".//div[contains(@class, 'lessons__new-item-title lessons__new-item-title_with-bg js-ellipse')]";
        } else {
            webElements = specializations;
            xpath = ".//div[contains(@class, 'lessons__new-item-title lessons__new-item-title_with-bg lessons__new-item-title_bundle')]";
        }

        return webElements
            .stream()
            .filter(el -> el.findElement(By.xpath(xpath)).getText().equals(searchText))
            .findFirst().get();
    }


    public WebElement getCourseByMinMaxDate(String courses, String minmax) {

        List<WebElement> webElements;
        String xpath;

        if (courses.equals("Популярные курсы")) {
            webElements = popular;
            xpath = ".//div[contains(@class, 'lessons__new-item-start')]";
        } else {
            webElements = specializations;
            xpath = ".//div[contains(@class, 'lessons__new-item-time')]";
        }

        SimpleDateFormat format = new SimpleDateFormat("d MMMM yyyy", new Locale("ru"));

        return webElements
            .stream()
            .filter(el -> getTimeFromDate(el, xpath, format) != 1000)
            .reduce((left, right) -> {

            if (getTimeFromDate(left, xpath, format) < getTimeFromDate(right, xpath, format)) {
                return minmax.equals("min") ? left : right;
            } else {
                return minmax.equals("min") ? right : left;
            }

        }).get();
    }


    public long getTimeFromDate(WebElement webElement, String xpath, SimpleDateFormat format) {

        String startDate = webElement.findElement(By.xpath(xpath)).getText();

        String dateForParse = parseString(startDate, Pattern.compile("[0-9]{1,2}\\s(января|февраля|марта|апреля|мая|июня|июля|августа|сентября|октября|ноября|декабря)\\s[0-9]{4}"));

        if (dateForParse.equals("")) {

            String tempDateForParse  = parseString(startDate, Pattern.compile("[0-9]{1,2}\\s(января|февраля|марта|апреля|мая|июня|июля|августа|сентября|октября|ноября|декабря)"));

            if (!tempDateForParse.equals("")) {
                dateForParse = tempDateForParse + " 2022";
            } else {
                return 1000;
            }
        }

        try {
            return format.parse(dateForParse).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 1000;
    }


    public String parseString(String dateString, Pattern pattern) {

        Matcher matcher = pattern.matcher(dateString);

        if (matcher.find()) {
            return dateString.substring(matcher.start(), matcher.end());
        }

        return "";
    }
}
