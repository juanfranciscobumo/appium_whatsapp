package co.com.whatsapp.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/whatsapp.feature"
, glue = "co/com/whatsapp/stepdefinitions"
, snippets = SnippetType.CAMELCASE)
public class RunnerWhatsapp {
}
