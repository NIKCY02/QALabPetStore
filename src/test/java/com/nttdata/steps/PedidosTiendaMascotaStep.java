package com.nttdata.steps;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;


public class PedidosTiendaMascotaStep {

    @Steps
    private Response response;

    private String URL_BASE = "https://petstore.swagger.io/v2";

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

    public void validateStatusCode(int i) {
        Response lastResponse = SerenityRest.lastResponse();
        Assert.assertNotNull("La respuesta es null. La solicitud GET podría haber fallado.", lastResponse);
        Assert.assertEquals("El código de respuesta no es el esperado", i, lastResponse.getStatusCode());
    }

    public void validarCampoEnRespuesta(String campo, int id) {
        int campoObtenido = SerenityRest.lastResponse().getBody().path(campo);
        Assert.assertEquals("El valor del campo no coincide", campoObtenido, id);
    }

    public void validarCampoRespuestaStatus(String respuestastatus, String campostatus) {
        String resultado = SerenityRest.lastResponse().getBody().path(respuestastatus);
        Assert.assertEquals("El valor del status no coincide", resultado, campostatus);
    }
}
