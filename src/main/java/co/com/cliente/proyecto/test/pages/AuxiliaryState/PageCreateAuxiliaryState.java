package co.com.cliente.proyecto.test.pages.AuxiliaryState;
import co.com.cliente.proyecto.test.business.InternalAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class PageCreateAuxiliaryState {
    WebDriver driver;

    @FindBy(how=How.XPATH,using="//iframe[@src=\"http://hibot-admin-ui-qa.s3-website-us-east-1.amazonaws.com/\"]")
    private WebElement iframeContent;

    @FindBy(how=How.XPATH,using = "/html/body/app-root/app-layout/nz-layout/nz-sider/div/app-sidenav/ul/li[2]/div/span/span")
    private WebElement lnkAdmin;



    @FindBy(how=How.XPATH,using = "/html/body/app-root/app-layout/nz-layout/nz-sider/div/app-sidenav/ul/li[1]/span/span")
    private WebElement tablero;


    @FindBy(how=How.XPATH,using = "//ul[@class=\"ng-star-inserted\"]//li[@ng-reflect-router-link='/,admin,states']")

    private WebElement lnkState;








    @FindBy(how=How.XPATH,using = "/html/body/app-root/app-state-master/div/div/h1")
    private WebElement lblState;

    @FindBy(how=How.XPATH,using = "/html/body/app-root/app-state-master/div/div/button")
    private WebElement btnCreate;

    @FindBy(how=How.XPATH,using = "//*[@id=\"cdk-overlay-18\"]/nz-modal/div/div[2]/div[1]/div/div[1]")
    private WebElement modal;

    @FindBy(how=How.ID,using = "sateFormName")
    private WebElement txtNameForm;

    @FindBy(how=How.XPATH,using = "//div[@class=\"ant-modal-content\"]//button/span[text()='Guardar']")
    private WebElement btnSave;

    @FindBy(how=How.XPATH,using = "//div[@class=\"ant-modal-content\"]//button/span[text()='Cancelar']")
    private WebElement btnCancel;

    @FindBy(how=How.XPATH,using = "//div[@class=\"ant-popover-buttons\"]//button//span[text()='Si']")
    private WebElement btnYes;

    @FindBy(how=How.XPATH,using = "//div[@class=\"ant-popover-buttons\"]//button//span[text()='No']")
    private WebElement btnNo;

    String xpath_fila = "/html/body/app-root/app-state-master/div/app-state-table/nz-table/div/nz-spin/div/div[2]/div/div/div/div/table/tbody/tr[1]";


    public  void verifyEntry(InternalAction internalAction){
        internalAction.waitElementVisible(tablero,5);
        internalAction.isElementPresent(tablero);
    }

    public void traceOptions(InternalAction internalAction){
        internalAction.click(lnkAdmin);
        internalAction.click(lnkState);

    }

    public void createAuxiliaryState(InternalAction internalAction){
        internalAction.waitElementVisible(lblState,10);
        internalAction.click(btnCreate);

    }

    public void swicthToIframe(InternalAction internalAction){
        internalAction.swithToIframe(iframeContent);
    }

    public void fillAuxiliaryStateForm(InternalAction internalAction,String name) {
        internalAction.sendText(txtNameForm,name);

        internalAction.clicJavaScript(btnCreate);
        internalAction.clicJavaScript(btnYes);

    }

    public void verifyAuxiliaryStateCreated(InternalAction internalAction,String name){
        List<WebElement> fila = internalAction.getDriver().findElements(By.xpath(xpath_fila));
         fila.stream().filter(c-> c.equals(name));
    }

}
