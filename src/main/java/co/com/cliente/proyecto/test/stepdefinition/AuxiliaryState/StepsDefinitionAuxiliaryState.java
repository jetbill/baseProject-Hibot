package co.com.cliente.proyecto.test.stepdefinition.AuxiliaryState;
import co.com.cliente.proyecto.test.business.AuxiliaryState.AuxiliaryStateController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepsDefinitionAuxiliaryState {



    @Given("^se autentica en hibot$")
    public void se_autentica_en_hibot() throws Throwable {
        AuxiliaryStateController.initApplication(0,"http://qa.hibot.us","Registro de estados auxiliares"," Se registra un estado");

    }

    @When("^ingresa el \"(.*?)\" y contrasena \"(.*?)\"$")
    public void ingresa_el_y_contrasena(String email, String password) throws Throwable {
        AuxiliaryStateController.autenticacion(email,password);

    }

    @Then("^valida el ingreso$")
    public void valida_el_ingreso() throws Throwable {
        AuxiliaryStateController.verifyEntry();



    }

    @Then("^se procede e registrar un estado$")
    public void se_procede_e_registrar_un_estado() throws Throwable {
        AuxiliaryStateController.traceOptions();


    }

    @When("^llena el formulario nombre\"(.*?)\"$")
    public void llena_el_formulario_nombre(String name) throws Throwable {
        AuxiliaryStateController.createAuxiliaryState();
        AuxiliaryStateController.fillAuxiliaryForm(name);

    }

    @Then("^valida el \"(.*?)\"$")
    public void valida_el(String name) throws Throwable {
        AuxiliaryStateController.verifyNameCreated(name);

    }
}
