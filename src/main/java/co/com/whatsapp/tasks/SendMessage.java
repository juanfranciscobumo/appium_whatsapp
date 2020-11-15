package co.com.whatsapp.tasks;

import static co.com.whatsapp.pages.PageWhatsapp.BTNNEWCHAT;
import static co.com.whatsapp.pages.PageWhatsapp.BTNSEND;
import static co.com.whatsapp.pages.PageWhatsapp.LBLMESSAGE;

import co.com.whatsapp.interactions.LookContact;
import co.com.whatsapp.model.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class SendMessage implements Task {
	private String contact;
	private String message;

	public SendMessage(TestData data) {
		this.contact = data.getContact();
		this.message = data.getMessage();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(BTNNEWCHAT), LookContact.onWhatsapp(contact),
				Enter.theValue(message).into(LBLMESSAGE), Click.on(BTNSEND));
	}

	public static SendMessage onWhatsapp(TestData data) {
		return Tasks.instrumented(SendMessage.class, data);
	}
}