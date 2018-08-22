package co.com.cliente.proyecto.test.business;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ManejadorControlesHtml<T> {
    private WebDriver driver;
    private Class<T> clazz;

    public ManejadorControlesHtml(WebDriver driver, Class<T> clazz) {
        this.driver = driver;
        this.clazz = clazz;
    }

    public List<T> obtenerTabla(List<WebElement> tableRows) {
        List<T> lista = new ArrayList<T>();
        List<String> properties =  new ArrayList<String>();
        for(Field field : clazz.getDeclaredFields()){
            properties.add(field.getName());
        }
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();


        for (WebElement element : tableRows) {
            ObjectNode objectNode = mapper.createObjectNode();
            int campoPosicion = 0;
            List<WebElement> tableColumns = element.findElements(By.xpath("td"));
            for (WebElement columns : tableColumns) {
                if(properties.size()>campoPosicion){
                    objectNode.put(properties.get(campoPosicion), columns.getText());
                }
                campoPosicion++;
            }
            objectNode.put("row",obtenerXPathAbsoluto(element));
            arrayNode.add(objectNode);
        }
        try {
            JavaType type = mapper.getTypeFactory().
                    constructCollectionType(List.class, clazz);
            lista = mapper.readValue(arrayNode.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String obtenerXPathAbsoluto(WebElement element)
    {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "function absoluteXPath(element) {"+
                        "var comp, comps = [];"+
                        "var parent = null;"+
                        "var xpath = '';"+
                        "var getPos = function(element) {"+
                        "var position = 1, curNode;"+
                        "if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
                        "return null;"+
                        "}"+
                        "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
                        "if (curNode.nodeName == element.nodeName) {"+
                        "++position;"+
                        "}"+
                        "}"+
                        "return position;"+
                        "};"+

                        "if (element instanceof Document) {"+
                        "return '/';"+
                        "}"+

                        "for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
                        "comp = comps[comps.length] = {};"+
                        "switch (element.nodeType) {"+
                        "case Node.TEXT_NODE:"+
                        "comp.name = 'text()';"+
                        "break;"+
                        "case Node.ATTRIBUTE_NODE:"+
                        "comp.name = '@' + element.nodeName;"+
                        "break;"+
                        "case Node.PROCESSING_INSTRUCTION_NODE:"+
                        "comp.name = 'processing-instruction()';"+
                        "break;"+
                        "case Node.COMMENT_NODE:"+
                        "comp.name = 'comment()';"+
                        "break;"+
                        "case Node.ELEMENT_NODE:"+
                        "comp.name = element.nodeName;"+
                        "break;"+
                        "}"+
                        "comp.position = getPos(element);"+
                        "}"+

                        "for (var i = comps.length - 1; i >= 0; i--) {"+
                        "comp = comps[i];"+
                        "xpath += '/' + comp.name.toLowerCase();"+
                        "if (comp.position !== null) {"+
                        "xpath += '[' + comp.position + ']';"+
                        "}"+
                        "}"+

                        "return xpath;"+

                        "} return absoluteXPath(arguments[0]);", element);
    }

}
