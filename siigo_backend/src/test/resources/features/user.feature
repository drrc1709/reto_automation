Feature: Crear un usuario en reqres.in

  @createUser
  Scenario: Crear un usuario exitosamente
    When Daniel crea un usuario con nombre "morpheus" y trabajo "leader"
    Then el usuario se creo exitosamente

  @searchUser
  Scenario Outline: Consultar usuarios
    When Daniel consulta el usuario por <id>
    Then el ve la informacion del usuario "<nombre>"

    Examples:
      | id | nombre  |
      | 2  | Janet   |
      | 4  | Eve     |
      | 6  | Tracey  |
      | 8  | Lindsay |
      | 12 | Rachel  |

  @updateUser
  Scenario Outline: Actualizar usuarios
    When Daniel actualiza el trabajo "<trabajo>" del usuario "<nombre>" con <id>
    Then el ve que el nuevo trabajo "<trabajo>" fue actualizado
    Examples:
      | id | trabajo   | nombre |
      | 2  | enfermera | Janet  |
      | 4  | piloto    | Eve    |
      | 6  | policia   | Tracey |

  @deleteUser
  Scenario: Eliminar usuario
    When Daniel elimna el usuario con id 12
    Then el ve que el usuario fue eliminado