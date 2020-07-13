package interactions;

import java.time.Duration;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Mover implements Interaction {
	@Override
	public <T extends Actor> void performAs(T actor) {
		int inicioX = BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getHeight() / 2;
		int inicioY = BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getWidth() / 3;
		int inicioFinY = BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getWidth();
		new TouchAction((PerformsTouchActions) BrowseTheWeb.as(actor).getDriver())
				.press(PointOption.point(inicioX, (int) (inicioFinY * 1.40)))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(inicioX, inicioY))
				.release().perform();
	}

	public static Mover scroll() {

		return Tasks.instrumented(Mover.class);
	}
}
