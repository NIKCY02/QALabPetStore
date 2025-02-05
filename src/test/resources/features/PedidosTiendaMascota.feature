@PetStore
Feature: Gestión de órdenes en PetStore

  @t1
  Scenario: Creación de una nueva Orden
    Given que la tienda este operativa
    When se envía una solicitud GET donde el ID es 4
    Then valida que el código de respuesta es 200
    And valida que el campo "status" tiene el valor "available"

  @t2
  Scenario: Consulta de una Orden existente
    Given que la tienda este operativa
    When se envía una solicitud GET donde el ID es 98632555
    Then valida que el código de respuesta es 404

  @t3
  Scenario Outline: Validar múltiples órdenes
    Given que la tienda este operativa
    When se envía una solicitud POST con un cuerpo válido donde el ID es <id> y el Status es "<status>"
    Then valida que el código de respuesta es 200
    And valida que el campo "id" tiene el valor <id>
    And valida que el campo "status" tiene el valor "<status>"

    Examples:
      | id  | status  |
      | 5   | placed  |
      | 2   | placed  |
