package co.com.cliente.proyecto.test.pages.channel;

import co.com.cliente.proyecto.test.business.InternalAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class PageCreateChannel {
    WebDriver driver;

    @FindBy(how=How.XPATH,using="/html/body/app-root/app-layout/nz-layout/nz-layout/nz-content/app-content/iframe")
    private WebElement iframeContent;

    @FindBy(how = How.XPATH,using = "/html/body/app-root/app-layout/nz-layout/nz-sider/div/app-sidenav/ul/li[2]/div/span/span")
    private WebElement lnkAdmin;

    @FindBy(how = How.XPATH,using = "/html/body/app-root/app-layout/nz-layout/nz-sider/div/app-sidenav/ul/li[2]/ul/ul/li[4]")
    private WebElement lnkChannel;


    @FindBy(how = How.XPATH,using = "/html/body/app-root/app-channel-master/div/div/button")
    private WebElement btnCrearChannel;

    @FindBy(how=How.XPATH,using = "/html/body/app-root/app-channel-master/div/div/h1")
    private WebElement lblChannel;

    @FindBy(how=How.XPATH,using = "//*[@id=\"cdk-overlay-16\"]/nz-modal/div/div[2]/div[1]/div/div[1]")
    private WebElement modal;

    @FindBy(how = How.ID,using = "channelFormAccount")
    private WebElement txtCuenta;

    @FindBy(how = How.XPATH,using = "//div[@class=\"ant-modal-content\"]//div[@ng-reflect-nz-place-holder='Seleccione un tipo de canal']//input")
    private WebElement cbxTipoCanal;

    @FindBy(how = How.XPATH,using = "//div[@class=\"ant-modal-content\"]//div[@ng-reflect-nz-place-holder='Seleccione una dirección']//input")
    private WebElement cbxDireccion;

    @FindBy(how = How.XPATH,using = "//div[@class=\"ant-modal-content\"]//button/span[text()='Guardar']")

    private WebElement btGuardar;

    @FindBy(how=How.XPATH,using="//div[@class=\"ant-popover-inner-content\"]//button//span[text()='Si']")
    private WebElement btnConfirmar;

    @FindBy(how = How.XPATH,using = "//div[@class=\"ant-modal-content\"]//button/span[text()='Cancelar']")
    private WebElement btnCancelar;

    @FindBy(how = How.XPATH,using = "/html/body/app-root/app-channel-master/div/app-channel-table/nz-table/div/nz-spin/div/div[2]/div/div/div/div/table/tbody")
    private WebElement table;

    String xpathFila = "/html/body/app-root/app-channel-master/div/app-channel-table/nz-table/div/nz-spin/div/div[2]/div/div/div/div/table/tbody/tr/td[1]";



    public  void verifyEntry(InternalAction internalAction){
        internalAction.waitElementVisible(lnkAdmin,1000);
        internalAction.isElementPresent(lnkAdmin);
    }

    public void traceOptions(InternalAction internalAction){
        internalAction.click(lnkAdmin);
        internalAction.click(lnkChannel);

    }

    public void createChannel(InternalAction internalAction){
        internalAction.waitElementVisible(lblChannel,1000);
        internalAction.click(btnCrearChannel);

    }

    public void swicthToIframe(InternalAction internalAction){
        internalAction.swithToIframe(iframeContent);
    }

    public void fillChannelForm(InternalAction internalAction,String cuenta,String canal,String dir) {
         internalAction.sendText(txtCuenta,cuenta);
         internalAction.sendText(cbxTipoCanal,canal);
        internalAction.sendEnter(cbxTipoCanal);
         internalAction.sendText(cbxDireccion,dir);
        internalAction.sendEnter(cbxDireccion);
        internalAction.clicJavaScript(btGuardar);
        internalAction.clicJavaScript(btnConfirmar);

    }

    public void verifyChannelCreated(InternalAction internalAction, String code){
        List<WebElement> fila = internalAction.getDriver().findElements(By.xpath(xpathFila));
        fila.stream().filter(c -> c.equals(code));
    }

    /*public List<ChannelDTO> fillTable(InternalAction internalAction){
        ManejadorControlesHtml<ChannelDTO> manejador = new ManejadorControlesHtml<ChannelDTO>(internalAction.getDriver(), ChannelDTO.class);
        List<WebElement> tableRows = new WebDriverWait(internalAction.getDriver(), 10).
                until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(table,By.tagName("tr")));
       return manejador.obtenerTabla(tableRows);
        //return pageChannelCreatedList.stream().filter(x->x.getCuenta().equals("300145695")).count()>0;

    }*/








}
