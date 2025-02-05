package com.nttdata.glue;
import com.nttdata.steps.PedidosTiendaMascotaStep;
import io.cucumber.java.en.And;
import  io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PedidosTiendaMascotaStepDef {

    PedidosTiendaMascotaStep orden = new PedidosTiendaMascotaStep();

    @Given("que la tienda este operativa")
    public void queLaTiendaEsteOperativa() {
    }

    @Then("valida que el código de respuesta es {int}")
    public void validaCodigoRespuesta(int i) {
        orden.validateStatusCode(i);
    }

    @When("se envía una solicitud GET donde el ID es {int}")
    public void seEnvíaUnaSolicitudGETDondeElIDEs(int id) {
        orden.enviarSolicitudGetOrden(id);
    }

    @And("valida que el campo {string} tiene el valor {int}")
    public void validaQueElCampoTieneElValor(String campo, int id) {
        orden.validarCampoEnRespuesta(String.valueOf(campo), id);
    }

    @When("se envía una solicitud POST con un cuerpo válido donde el ID es {int} y el Status es {string}")
    public void seEnvíaUnaSolicitudPOSTConUnCuerpoVálidoDondeElIDEsIdYElStatusEs(int id, String stat) {
        orden.enviarSolicitudPostOrdenValida(id, stat);
    }

    @And("valida que el campo {string} tiene el valor {string}")
    public void validaQueElCampoTieneElValor(String campo, String campovalor) {
        orden.validarCampoRespuestaStatus(campo, campovalor);
    }
}

