Feature: Registar un Estado Auxiliar en Hibot

  @Create-AuxiliaryState
  Scenario Outline: se registra un nuevo estado auxiliar
    Given se autentica en hibot
    When ingresa el "<email>" y contrasena "<password>"
    Then  valida el ingreso
    And  se procede e registrar un estado
    When llena el formulario nombre"<nombre>"
    Then valida el "<estado>"

    Examples:

      |email                        |password  |nombre   |estado   |
      |william.renteria@sofka.com.co|William123|UNESTADO |UNESTADO |