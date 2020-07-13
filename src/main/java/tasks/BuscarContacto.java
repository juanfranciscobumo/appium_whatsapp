package tasks;

import java.util.NoSuchElementException;

import interactions.Mover;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import pages.PageWhatsapp;

public class BuscarContacto implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(PageWhatsapp.NUEVOCHAT));
		boolean a = true;
		while (a) {
			actor.attemptsTo(Mover.scroll());
			if (PageWhatsapp.BUSCARCONTACTO.resolveFor(actor).isCurrentlyVisible()) {
				actor.attemptsTo(Click.on(PageWhatsapp.BUSCARCONTACTO));
				a = false;
				break;
			}

		}
		if (!PageWhatsapp.BUSCARCONTACTO.resolveFor(actor).isCurrentlyVisible()) {
			throw new NoSuchElementException(PageWhatsapp.BUSCARCONTACTO.getName() + " no encontrado");
		}
		actor.attemptsTo(Enter.theValue(
				"Señora karen le habla nuevamente el robot de su novio, le pido disculpas nuevamente, pues andamos haciendo unas pruebas, por lo que le llegara varias veces este mensaje")
				.into(PageWhatsapp.MENSAJE), Click.on(PageWhatsapp.ENVIAR)

		);
	}

	public static BuscarContacto enWhatsapp() {
		return Tasks.instrumented(BuscarContacto.class);
	}
}