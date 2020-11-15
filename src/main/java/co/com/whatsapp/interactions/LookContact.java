package co.com.whatsapp.interactions;

import static co.com.whatsapp.pages.PageWhatsapp.BTNLOOKCONTACT;

import java.util.NoSuchElementException;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class LookContact implements Interaction {
	private static final String NO_FOUND = "no encontrado";
	private String contact;

	public LookContact(String contact) {
		this.contact = contact;

	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		while (true) {
			actor.attemptsTo(Move.scroll());
			if (BTNLOOKCONTACT.of(contact).resolveFor(actor).isCurrentlyVisible()) {
				actor.attemptsTo(Click.on(BTNLOOKCONTACT.of(contact)));
				break;
			}
		}
		if (!BTNLOOKCONTACT.of(contact).resolveFor(actor).isCurrentlyVisible()) {
			throw new NoSuchElementException(BTNLOOKCONTACT.of(contact).getName() + NO_FOUND);
		}

	}

	public static LookContact onWhatsapp(String contact) {
		return Tasks.instrumented(LookContact.class, contact);
	}

}
