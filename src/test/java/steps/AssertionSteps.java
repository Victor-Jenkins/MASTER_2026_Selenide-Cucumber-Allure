package steps;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;

import java.time.Duration;

public class AssertionSteps {

    @BeforeAll
    public static void setUpAll() {
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;            // 15 s máximo espera
        Configuration.pageLoadTimeout = 30000;    // 30 s para cargar la página
        // Puedes ajustar otras configuraciones según tu CI
    }

    @AfterAll
    public static void tearDownAll() {
        closeWebDriver();
    }

    @Then("the page should contain text {string}")
    public void the_page_should_contain_text(String text) {
        // Espera que el body esté visible
        SelenideElement body = $("body").shouldBe(com.codeborne.selenide.Condition.visible, Duration.ofSeconds(15));
        // En caso de que exista banner o overlay lo cerramos (ejemplo genérico)
        // Ajusta el selector al que tengas en tu página
        if ($("div.banner-close-button").exists()) {
            $("div.banner-close-button").click();
        }
        String bodyText = body.getText();
        assertTrue(bodyText.contains(text),
                "Expected to find text [" + text + "] in page body but was: " + bodyText);
    }
}

