package co.com.whatsapp.questions;

import co.com.whatsapp.pages.PageWhatsapp;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheMessageWasSend {

	public static Question<String> at() {
		return actor -> Text.of(PageWhatsapp.LBLCONTAC).viewedBy(actor).asString();
	}

	public static Question<String> withMessage() {
		return actor -> Text.of(PageWhatsapp.LBLMESSAGE_SEND).viewedBy(actor).asList()
				.get(Text.of(PageWhatsapp.LBLMESSAGE_SEND).viewedBy(actor).asList().size() - 1);
	}
}