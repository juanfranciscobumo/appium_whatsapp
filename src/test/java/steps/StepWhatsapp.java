package steps;

import static drivers.DriverWhatsapp.hisBrowserMovil;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import tasks.BuscarContacto;

public class StepWhatsapp {
	@Managed
	WebDriver driver;

	@Before
	public void set_the_stage() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Dado("^que (.*) se encuentre en Whatsapp$")
	public void queJuanSeEncuentreEnWhatsapp(String juan) {
		theActorCalled(juan).can(BrowseTheWeb.with(hisBrowserMovil().android()));

	}

	@Cuando("^busque el contacto$")
	public void busqueElContacto() {

		theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowserMovil().android()));
		theActorInTheSpotlight().attemptsTo(BuscarContacto.enWhatsapp());
	}

	@Cuando("^envie el mensaje$")
	public void envieElMensaje() {

	}

	@Entonces("^vera que el mensaje fue enviado$")
	public void veraQueElMensajeFueEnviado() {

	}
}
