package com.nttdata.steps;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class PedidosTiendaMascotaStep {

    @Steps
    private Response response;

    private String URL_BASE = "https://petstore.swagger.io/v2";

    @Step("Crear orden con id {0} y estado {1} en PetStore")
    public void enviarSolicitudPostOrdenValida(int id, String status) {
        SerenityRest.given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": 10,\n" +
                        "  \"quantity\": 2,\n" +
                        "  \"shipDate\": \"2025-02-04T12:00:00Z\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post("/store/order/")
                .then()
                .log().all();
    }

    public void enviarSolicitudGetOrden(int id) {
        response = SerenityRest.given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .log()
                .all()
                .when()
                .get("/store/order/" + id);

        System.out.println("Respuesta completa: " + response.asString());
    }

    @Step("Validar que el código de respuesta sea {int}")
    public void validateStatusCode(int i) {
        Response lastResponse = SerenityRest.lastResponse();
        Assert.assertNotNull("La respuesta es null. La solicitud GET podría haber fallado.", lastResponse);
        Assert.assertEquals("El código de respuesta no es el esperado", i, lastResponse.getStatusCode());
        //Assert.assertEquals(i,SerenityRest.lastResponse().getStatusCode());
        //Assert.assertEquals(i,SerenityRest.lastResponse().getStatusCode());
        //assertThat(lastResponse().statusCode(), is(i));
    }


    @Step("Validar que el campo {0} en la respuesta tenga el valor esperado {1}")
    public void validarCampoEnRespuesta(String campo, int id) {
        Object valorObtenido = SerenityRest.lastResponse().getBody().path(campo);
        Assert.assertEquals("El valor del campo no coincide",
                campo,
                id);
    }

    @Step("Validar que el mensaje en la respuesta sea {0}")
    public void validarMensajeEnRespuesta(String mensajeEsperado) {
        String mensajeObtenido = SerenityRest.lastResponse().getBody().path("message");
        Assert.assertEquals("El mensaje no coincide",
                mensajeEsperado,
                mensajeObtenido);
    }
}
