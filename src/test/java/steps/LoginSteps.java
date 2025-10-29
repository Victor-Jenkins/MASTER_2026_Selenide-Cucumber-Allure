package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    @Given("I open the login page")
    public void i_open_the_login_page() {
        open("https://wikipedia.com");
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_credentials(String user, String pass) {
        $("#searchInput").shouldBe(visible).click();
        $("#searchInput").type("Hello World");
        $("#search-form > fieldset > button > i").shouldBe(visible).click();
    }

    @Then("I should see a success message")
    public void i_should_see_success_message() {
        $("#pt-login-2").shouldBe(visible).click();
        String text = $("#wpName1").getText();
        $("#wpName1").shouldBe(visible).type("Victor");
        $("#wpPassword1").shouldBe(visible).type("Success");
        $("#wpLoginAttempt").shouldBe(visible).click();



    }

    @Then("I should see an error message")
    public void i_should_see_error_message() {
        $("#pt-login-2").shouldBe(visible).click();
        String text = $("#wpName1").getText();
        $("#wpName1").shouldBe(visible).type("1121$%&/&@3");
        $("#wpPassword1").shouldBe(visible).type("Failed Login");
        $("#wpLoginAttempt").shouldBe(visible).click();


    }
}
