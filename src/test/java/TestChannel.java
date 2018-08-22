import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/CreateChannel.feature",tags = "@Crear-Canal"
        ,glue={"co/com/cliente/proyecto/test/stepdefinition/"}
        ,format = {"pretty", "html:target/Destination"}
)

public class TestChannel {
}
