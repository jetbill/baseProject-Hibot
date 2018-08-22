package co.com.cliente.proyecto.test.stepdefinition.channels;
import co.com.cliente.proyecto.test.business.channel.ChannelController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepsDefinitionChannels {

    //ChannelController channelController = new ChannelController();


    @Given("^se autentica en la plataforma$")
    public void se_autentica_en_la_plataforma() throws Throwable {
        ChannelController.initApplication(0,"http://qa.hibot.us","Registro de Canales","Registrando un canal");
    }

    @When("^digita email \"(.*?)\" y contrasena \"(.*?)\"$")
    public void digita_email_y_contrasena(String email, String password) throws Throwable {
        ChannelController.authentication(email,password);

    }

    @Then("^verifica el ingreso$")
    public void verifica_el_ingreso() throws Throwable {
        ChannelController.verifyEntry();

    }

    @Then("^sigue la ruta$")
    public void sigue_la_ruta() throws Throwable {
        ChannelController.traceOptions();
    }



    @When("^llena el formulario cuenta \"(.*?)\" canal\"(.*?)\" direccion\"(.*?)\"$")
    public void llena_el_formulario_cuenta_canal_direccion(String cuenta, String canal, String dir) throws Throwable {
        ChannelController.createChannel();
        ChannelController.fillChannelForm(cuenta,canal,dir);
    }

    @Then("^verifica el registro \"(.*?)\"$")
    public void verifica_el_registro(String registro) throws Throwable {
        ChannelController.verifyAccountCreated(registro);


    }


}
