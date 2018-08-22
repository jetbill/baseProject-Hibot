package co.com.cliente.proyecto.test.pages;
import co.com.cliente.proyecto.test.business.InternalAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageIndex {
    @FindBy(how= How.ID, using = "email")
    private WebElement txtEmail;
    @FindBy(how= How.ID, using = "password")
    private WebElement txtPassword;
    @FindBy(how= How.ID, using = "btn-login")
    private WebElement btnLogin;

    public void loginHibot(InternalAction internalAction,String email,String password){
        internalAction.waitElementVisible(txtEmail,1000);
        internalAction.sendText(txtEmail,email);
        internalAction.sendText(txtPassword,password);
        internalAction.click(btnLogin);
    }

}
