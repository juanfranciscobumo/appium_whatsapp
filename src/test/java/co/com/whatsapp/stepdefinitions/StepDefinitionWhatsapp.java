package co.com.whatsapp.stepdefinitions;

import static co.com.whatsapp.builders.DatosBuilder.contact;
import static co.com.whatsapp.drivers.DriverWhatsapp.hisBrowserMovil;
import static co.com.whatsapp.exceptions.WhatsappException.CONTACT_NO_FOUND;
import static co.com.whatsapp.exceptions.WhatsappException.MESSAGE_NO_FOUND;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.whatsapp.exceptions.WhatsappException;
import co.com.whatsapp.questions.TheMessageWasSend;
import co.com.whatsapp.tasks.SendMessage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class StepDefinitionWhatsapp {

	@Before
	public void set_the_stage() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("^that (.*) is on whatsapp$")
	public void thatJuanIsOnWhatsapp(String juan) {
		theActorCalled(juan).whoCan(BrowseTheWeb.with(hisBrowserMovil().android()));
	}

	@When("^look the personal contact (.*) and send the message (.*)$")
	public void lookThePersonalContactMyNenaAndSendTheMessageEstoEsUnMensajeDePrueba(String contact, String message) {
		theActorInTheSpotlight().attemptsTo(SendMessage.onWhatsapp(contact(contact).andSendMessage(message)));
	}

	@Then("^juan will check that message was send at contact (.*) with message (.*)$")
	public void juanWillCheckThatMessageWasSendAtContactMyNenaWithMessageDisculpeSeñorita(String contact,
			String message) {
		theActorInTheSpotlight().should(
				seeThat(TheMessageWasSend.at(), equalTo(contact)).orComplainWith(WhatsappException.class,
						CONTACT_NO_FOUND),
				seeThat(TheMessageWasSend.withMessage(), equalTo(message)).orComplainWith(WhatsappException.class,
						MESSAGE_NO_FOUND));
	}
}
