package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class MascotaStep {

    private String URL_BASE = "https://petstore.swagger.io/v2/";
    public void consulta(int idMascota, String idMascota2) {
        System.out.println("Consultar Macota" + idMascota2);

        SerenityRest.given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .log().all()
                //.get("pet/" + String.valueOf(idMascota))
                .get("pet/" + idMascota2)
                .then()
                .log().all()
                //.statusCode(200)
                ;
    }

    public void validarStatusCode(int statusCode) {

        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }

    public void validoRespuesta(String msg) {
        String respuesta = SerenityRest.lastResponse().getBody().path("message");
        //System.out.println("Obtenido: " + respuesta);
        Assert.assertEquals(msg, respuesta);
    }
}
