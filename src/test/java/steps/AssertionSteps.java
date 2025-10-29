package steps;

import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionSteps {

    @Then("the page should contain text {string}")
    public void the_page_should_contain_text(String text) {
        String body = $("body").getText();
        assertTrue(body.contains(text));
    }
}
