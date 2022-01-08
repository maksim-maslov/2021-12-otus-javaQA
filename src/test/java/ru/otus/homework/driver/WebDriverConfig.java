package ru.otus.homework.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

public class WebDriverConfig {

    public static AbstractDriverOptions getOptions(AbstractDriverOptions options) {
        options.setScriptTimeout(Duration.ofSeconds(30));
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return options;
    }
}
