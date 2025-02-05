package com.nttdata.glue;
import com.nttdata.steps.MascotaStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MascotaStepDef {

    MascotaStep mascota = new MascotaStep();
    @When("consulto la tienda de mascota con IDMASCOTA {int} y la mascota2 {string}")
    public void consultoLaTiendaDeMascotaConIDMASCOTA(int idMascota, String idMascota2) {
        mascota.consulta(idMascota, idMascota2);
    }

    @Then("valido el código de respuesta sea {int}")
    public void validoElCódigoDeRespuestaSea(int statusCode) {
        mascota.validarStatusCode(statusCode);
    }

    @And("valido la respuesta sea {string}")
    public void validoLaRespuestaSea(String msg) {
        mascota.validoRespuesta(msg);
    }
}
