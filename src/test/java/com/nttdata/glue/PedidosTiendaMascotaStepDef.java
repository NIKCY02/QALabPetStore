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

    /*@When("se envía una solicitud POST a \"/store/order\" con un cuerpo válido")
    public void seEnvíaUnaSolicitudPOSTAConUnCuerpoVálido() {
        orden.enviarSolicitudPostOrdenValida(1, "placed");
    }*/

    @Then("valida que el código de respuesta es {int}")
    public void validaCodigoRespuesta(int i) {
        orden.validateStatusCode(i);
    }

    /*@And("valida que el campo {string} tiene el valor {int}")
    public void validaCampoString(String campo, int valorEsperado) {
        orden.validarCampoEnRespuesta(campo, valorEsperado);
    }*/


    @When("se envía una solicitud POST al endpoint \"/store/order\" con un cuerpo válido para el id {int} y estado {string}")
    public void seEnviaUnaSolicitudPostConParametros(int id, String status) {
        orden.enviarSolicitudPostOrdenValida(id, status);
    }


    @When("se envía una solicitud GET donde el ID es {int}")
    public void seEnvíaUnaSolicitudGETDondeElIDEs(int id) {
        orden.enviarSolicitudGetOrden(id);
    }

    @When("se envía una solicitud POST con un cuerpo válido")
    public void seEnvíaUnaSolicitudPOSTConUnCuerpoVálido() {
        orden.enviarSolicitudPostOrdenValida(1, "placed");
    }

    /*@And("valida que el campo {string} tiene el valor {string}")
    public void validaQueElCampoTieneElValor(String campo, int id) {
        orden.validarCampoEnRespuesta(campo, id);
    }*/

    @And("valida que el campo <id> tiene el valor {string}")
    public void validaQueElCampoIdTieneElValor(String arg0) {
    }

    @And("valida que el campo {string} tiene el valor {int}")
    public void validaQueElCampoTieneElValor(String campo, int id) {
        orden.validarCampoEnRespuesta(String.valueOf(campo), id);
    }

    @And("valida que el campo {string} tiene el valor {string}")
    public void validaQueElCampoTieneElValor(String arg0, String arg1) {
    }
}

