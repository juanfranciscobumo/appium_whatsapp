package pages;

import net.serenitybdd.screenplay.targets.Target;

public class PageWhatsapp {

    public static final Target NUEVOCHAT=Target.the("NUEVOCHAT").locatedBy("//android.widget.ImageButton[@content-desc=\"Nuevo chat\"]");
    public static final Target BUSCARCONTACTO=Target.the("BUSCARCONTACTO").locatedBy("//*[@text='My Nena']");
    public static final Target MENSAJE=Target.the("BUSCARCONTACTO").locatedBy("//*[@class='android.widget.EditText']");
    public static final Target ENVIAR=Target.the("BUSCARCONTACTO").locatedBy("//*[@resource-id='com.whatsapp:id/send']");
}
