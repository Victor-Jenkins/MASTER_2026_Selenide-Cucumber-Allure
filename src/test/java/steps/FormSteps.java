package steps;

import io.cucumber.java.en.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormSteps {

    @Given("I open the demoqa form page")
    public void i_open_the_demoqa_form_page() {
        open("https://demoqa.com/text-box");
    }

    @When("I fill the contact form with name {string} and email {string}")
    public void i_fill_the_contact_form(String name, String email) {
        $("#userName").shouldBe(visible).setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue("Calle Falsa 123");
        $("#permanentAddress").setValue("Dirección Permanente 456");
        $("#submit").click();
    }

    @Then("the output should contain the name {string}")
    public void the_output_should_contain_name(String name) {
        $("#output").shouldBe(visible);
        String text = $("#name").getText();
        assertTrue(text.contains(name));
    }
}
