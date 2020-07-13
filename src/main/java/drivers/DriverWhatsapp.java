package drivers;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverWhatsapp {

	private static AppiumDriver<MobileElement> driver;

	public static DriverWhatsapp hisBrowserMovil() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "ANDROID");
			capabilities.setCapability("deviceName", "ZH33F22BF3");
			capabilities.setCapability("appPackage", "com.whatsapp");
			capabilities.setCapability("appActivity", "com.whatsapp.HomeActivity");
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", true);
			driver = new AppiumDriver<>(new URL("http://localhost:4730/wd/hub"), capabilities);

		} catch (Exception e) {
			e.getMessage();
		}
		return new DriverWhatsapp();
	}

	public AppiumDriver<MobileElement> android() {
		return driver;
	}
}
