package co.com.whatsapp.interactions;

import java.time.Duration;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Move implements Interaction {
	@SuppressWarnings("rawtypes")
	@Override
	public <T extends Actor> void performAs(T actor) {	
	
		new TouchAction((PerformsTouchActions) BrowseTheWeb.as(actor).getDriver())
				.press(PointOption.point(BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getHeight() / 2, (int) (BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getWidth() * 1.40)))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getHeight() / 2, BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getWidth() / 3))
				.release().perform();
	
	}

	public static Move scroll() {

		return Tasks.instrumented(Move.class);
	}
}
