import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/AuxiliaryState.feature",tags = "@Create-AuxiliaryState"
        ,glue={"co/com/cliente/proyecto/test/stepdefinition/AuxiliaryState/"}
        ,format = {"pretty", "html:target/Destination"}
)
public class TestAuxiliaryState {
}
