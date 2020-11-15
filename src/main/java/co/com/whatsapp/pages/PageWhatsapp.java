package co.com.whatsapp.pages;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class PageWhatsapp {

	public static final Target BTNNEWCHAT = Target.the("BUTTON NEW CHAT").located(By.id("com.whatsapp:id/fab"));
	public static final Target BTNLOOKCONTACT = Target.the("BUTTON LOOK CONTACT").locatedBy("//*[@text='{0}']");
	public static final Target LBLMESSAGE = Target.the("LABEL MESSAGE")
			.locatedBy("//*[@class='android.widget.EditText']");
	public static final Target BTNSEND = Target.the("BUTTON SEND MESSAGE")
			.locatedBy("//*[@resource-id='com.whatsapp:id/send']");

	public static final Target LBLCONTAC = Target.the("LABEL CONTACT")
			.locatedBy("//*[@resource-id='com.whatsapp:id/conversation_contact_name']");
	public static final Target LBLMESSAGE_SEND = Target.the("LABEL SENT MESSAGE")
			.locatedBy("//*[@resource-id='com.whatsapp:id/message_text']");

}
