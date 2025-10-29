package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Hooks {

    @Before(order = 0)
    public void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        String browser = System.getProperty("browser");
        if (browser == null || browser.isBlank()) {
            browser = System.getenv("BROWSER");
        }
        if (browser == null || browser.isBlank()) browser = "chrome";

        String headless = System.getProperty("headless");
        if (headless == null) headless = System.getenv("HEADLESS");
        boolean isHeadless = "true".equalsIgnoreCase(headless);

        Configuration.browser = browser;
        Configuration.headless = isHeadless;
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;

        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
            }

            // Evitar conflictos de directorio de usuario
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--user-data-dir=/tmp/selenide-" + System.currentTimeMillis());

            Configuration.browserCapabilities = options;
        }

    }
}
