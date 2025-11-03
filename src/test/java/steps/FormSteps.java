package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class FormSteps {

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

    @Given("I open the demoqa form page")
    public void i_open_the_demoqa_form_page() {
        open("https://demoqa.com/text-box");
        $("body").shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I fill the contact form with name {string} and email {string}")
    public void i_fill_the_contact_form(String name, String email) {
        SelenideElement nameInput = $("#userName").shouldBe(visible, Duration.ofSeconds(10));
        nameInput.setValue(name);

        SelenideElement emailInput = $("#userEmail").shouldBe(visible, Duration.ofSeconds(10));
        emailInput.setValue(email);

        $("#currentAddress").setValue("Calle Falsa 123");
        $("#permanentAddress").setValue("Dirección Permanente 456");

        // Asegúrate de que el botón submit esté visible y habilitado
        SelenideElement submitBtn = $("#submit").shouldBe(visible, Duration.ofSeconds(10));
        submitBtn.scrollIntoView(true).click();
    }

    @Then("the output should contain the name {string}")
    public void the_output_should_contain_name(String name) {
        // Asegúrate de que el bloque de output aparezca
        SelenideElement outputBlock = $("#output").shouldBe(visible, Duration.ofSeconds(15));
        String text = $("#name").getText();
        assertTrue(text.contains(name),
                "Expected output to contain name [" + name + "] but actual text was: " + text);
    }
}
