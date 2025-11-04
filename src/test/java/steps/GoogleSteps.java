package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GoogleSteps {
    @BeforeAll
    public static void setUpAll() {
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000; // 15 s
        Configuration.pageLoadTimeout = 30000; // 30 s
    }

    @AfterAll
    public static void tearDownAll() {
        closeWebDriver();
    }
    @Given("I open Google")
    public void i_open_google() {
        open("https://github.com/");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        $("body > div.logged-out.env-production.page-responsive.header-overlay.header-overlay-fixed.js-header-overlay-fixed > div.position-relative.header-wrapper.js-header-wrapper > header > div > div.HeaderMenu.js-header-menu.height-fit.position-lg-relative.d-lg-flex.flex-column.flex-auto.top-0 > div > div > div > a").shouldBe(visible).click();
        $("#login_field").shouldBe(visible).setValue(query).type("Victor");
        $("#password").shouldBe(visible).setValue(query).type("Testing on Github @ ");

    }

    @Then("I open the first result")
    public void i_open_the_first_result() {

        $("body > div.logged-out.env-production.page-responsive.session-authentication > div.application-main > main > div > div.authentication-body.authentication-body--with-form.new-session > form > div:nth-child(4) > input").shouldBe(visible).click();
        sleep(1000);
        $(By.xpath("//*[@id=\"js-flash-container\"]/div/div/div"))
                .shouldHave(exactText("Incorrect username or password."));


    }

    @Then("the current url should not contain google")
    public void the_current_url_should_not_contain_google() {
        String url = webdriver().driver().getWebDriver().getCurrentUrl();
        assertFalse(url.contains("Google.com"));
    }

    @Given("the Google search page")
    public void theGoogleSearchPage() {
    }

    @When("we search for {string}")
    public void weSearchFor(String arg0) {
    }

    @Then("the first result must be {string}")
    public void theFirstResultMustBe(String arg0) {
    }
}
