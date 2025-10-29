package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationSteps {

    @Given("I navigate from {string} to {string}")
    public void i_navigate_from_to(String from, String to) {
        open(from);
        sleep(500);
        open(to);
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String titlePart) {
        String t = title();
        assertTrue(t.toLowerCase().contains(titlePart.toLowerCase()));
    }
}
