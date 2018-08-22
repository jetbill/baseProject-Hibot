package co.com.cliente.proyecto.test.business;

import co.com.sofka.test.gui.GeneralActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InternalAction extends GeneralActions {

    public InternalAction(String carpeta) {
        super(carpeta);
    }

    public InternalAction() {
        super();
    }
    public void focusElement(WebElement element){
        new Actions(driver).moveToElement(element).perform();
    }
    public void hoverNClickElement(WebElement element2Hover,WebElement element2click){
        new Actions(driver).moveToElement(element2Hover).moveToElement(element2click).click().build().perform();
    }

    public void swithToIframe(WebElement element){
        driver.switchTo().frame(element);
    }

    public void clicJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
