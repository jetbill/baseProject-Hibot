package co.com.cliente.proyecto.test.business.channel;

import co.com.cliente.proyecto.test.business.InternalAction;
import co.com.cliente.proyecto.test.pages.PageIndex;
import co.com.sofka.test.gui.ManagementBrowser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import co.com.cliente.proyecto.test.pages.channel.PageCreateChannel;


public class ChannelController {

    private static InternalAction internalAction;
    private static WebDriver driver;


    public static void initApplication(int navegador, String url, String carpeta, String funcionalidad) {

        ManagementBrowser browser = new ManagementBrowser();
        try {
            driver = browser.getDriverBrowser(0);
        } catch (Exception e) {

            internalAction.printFailure("No fué posible obtener del driver del navegador para pruebas" + e);
            internalAction.closeAndQuitTest();
            Assert.fail("No fué posible obtener del driver del navegador para pruebas");
        }
        internalAction = new InternalAction(carpeta);
        internalAction.setFuncionalidad(funcionalidad);
        internalAction.setDriver(driver);
        internalAction.printMessage("*****************************************************************************");
        internalAction.printMessage("INICIO TRANSACCIÓN: " + funcionalidad + "");
        internalAction.printMessage("*****************************************************************************");
        try {
            internalAction.openUrl(url);
            internalAction.printMessage("Se abrió la url " + url + " exitosamente");
        } catch (Exception e) {
            internalAction.printFailure("No se abrió la URL de la aplicación parametrizada:" + " " + e);

        }
    }

    public static void authentication(String email, String password) {

        PageIndex pageIndex = PageFactory.initElements(internalAction.getDriver(), PageIndex.class);
        pageIndex.loginHibot(internalAction,email,password);


    }

    public static void verifyEntry(){
        PageCreateChannel pageCreateChannel = PageFactory.initElements(internalAction.getDriver(), PageCreateChannel.class);
        pageCreateChannel.verifyEntry(internalAction);

    }

    public static void traceOptions(){
        PageCreateChannel pageCreateChannel = PageFactory.initElements(internalAction.getDriver(), PageCreateChannel.class);
        pageCreateChannel.traceOptions(internalAction);
    }

    public static void createChannel(){
        PageCreateChannel pageCreateChannel = PageFactory.initElements(internalAction.getDriver(), PageCreateChannel.class);
        pageCreateChannel.swicthToIframe(internalAction);
        pageCreateChannel.createChannel(internalAction);
    }

    public static void fillChannelForm(String cuenta,String canal,String dir) {
        PageCreateChannel pageCreateChannel = PageFactory.initElements(internalAction.getDriver(), PageCreateChannel.class);
        pageCreateChannel.fillChannelForm(internalAction,cuenta,canal,dir);

    }

    public static void verifyAccountCreated(String code){
        PageCreateChannel pageCreateChannel = PageFactory.initElements(internalAction.getDriver(), PageCreateChannel.class);
        pageCreateChannel.verifyChannelCreated(internalAction,code);
        //internalAction.closeAndQuitTest();


    }



}
