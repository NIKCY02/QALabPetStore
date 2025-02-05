@ProbarFeatureMascota
Feature: Mascota

  @crearMascota
  Scenario: Crear Mascota




    @consultarMascota
    Scenario: Consultar Mascota
      When consulto la tienda de mascota con IDMASCOTA 2 y la mascota2 "159"
      Then valido el código de respuesta sea 200
      And valido la respuesta sea "Pet not found"