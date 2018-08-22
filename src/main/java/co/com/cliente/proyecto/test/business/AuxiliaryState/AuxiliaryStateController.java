package co.com.cliente.proyecto.test.business.AuxiliaryState;

import co.com.cliente.proyecto.test.business.InternalAction;
import co.com.cliente.proyecto.test.pages.AuxiliaryState.PageCreateAuxiliaryState;
import co.com.cliente.proyecto.test.pages.PageIndex;
import co.com.sofka.test.gui.ManagementBrowser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class AuxiliaryStateController {
    private  static InternalAction internalAction;
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

    public static void autenticacion(String email, String password) {
        PageIndex pageIndex = PageFactory.initElements(internalAction.getDriver(), PageIndex.class);
        pageIndex.loginHibot(internalAction,email,password);


    }

    public static void verifyEntry(){
        PageCreateAuxiliaryState pageCreateAuxiliaryState = PageFactory.initElements(internalAction.getDriver(), PageCreateAuxiliaryState.class);
        pageCreateAuxiliaryState.verifyEntry(internalAction);

    }

    public static void traceOptions(){
        PageCreateAuxiliaryState pageCreateAuxiliaryState = PageFactory.initElements(internalAction.getDriver(),PageCreateAuxiliaryState.class);
        pageCreateAuxiliaryState.traceOptions(internalAction);
        pageCreateAuxiliaryState.swicthToIframe(internalAction);

    }

    public static void createAuxiliaryState(){
        PageCreateAuxiliaryState pageCreateAuxiliaryState = PageFactory.initElements(internalAction.getDriver(),PageCreateAuxiliaryState.class);
        pageCreateAuxiliaryState.createAuxiliaryState(internalAction);

    }

    public static void fillAuxiliaryForm(String name){
        PageCreateAuxiliaryState pageCreateAuxiliaryState = PageFactory.initElements(internalAction.getDriver(),PageCreateAuxiliaryState.class);
        pageCreateAuxiliaryState.fillAuxiliaryStateForm(internalAction,name);

    }

    public static void verifyNameCreated(String name){
        PageCreateAuxiliaryState pageCreateAuxiliaryState = PageFactory.initElements(internalAction.getDriver(),PageCreateAuxiliaryState.class);
        pageCreateAuxiliaryState.verifyAuxiliaryStateCreated(internalAction,name);

    }
}
