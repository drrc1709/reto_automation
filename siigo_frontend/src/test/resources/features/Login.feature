@SignIn @E2E
Feature: SignIn

  @CP008
  Scenario: Login exitoso
    Given Daniel es un usuario registrado en la app
    When el inicia sesión
    Then el puede ver en el dashboard el usuario "automation"