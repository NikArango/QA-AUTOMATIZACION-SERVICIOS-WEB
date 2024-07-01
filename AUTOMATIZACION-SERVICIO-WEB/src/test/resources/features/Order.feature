Feature: Prueba de Servicio
  Background:
    Given consulto disponibilidad  del Servicio de URL_BASE  "https://petstore.swagger.io"


  @consultartest
  Scenario Outline: consulta de orden

    Given la URL_BASE del Servicio responde <codigoRespuesta>
    When consulto el Servicio con el Path "/v2/store/order/" y el parametro de  <id> de orden
    Then valido el codigo de respuesta sea <codigoRespuesta>
    And valido el parametro "id" tenga el contenido numerico <id>
    #And valido el parametro "complete" tenga el contenido "<complete>"
    #And valido el parametro "category.name" tenga el contenido "<cateogira>"

    Examples:
      | id      | codigoRespuesta |
      | 1      | 200              |
      | 2       | 200             |
     # | id      | codigoRespuesta | status | complete |
     # | 21       | 200             | approved  | false   |
     # | 9        | 200             | placed    | true |

  @creartest
  Scenario Outline: creacion de  orden

    Given la URL_BASE del Servicio responde <codigoRespuesta>
    When establezco  el Path "/v2/store/order"
    And creo la orden con <id>,<petId>,<quantity>,"<shipDate>","<status>","<complete>"
    Then valido el codigo de respuesta sea <codigoRespuesta>
    And valido el parametro "id" tenga el contenido numerico <id>
    And valido el parametro "petId" tenga el contenido numerico <petId>
    And valido el parametro "quantity" tenga el contenido numerico <quantity>
    #And valido el parametro "shipDate" tenga el contenido de cadena "<shipDate>"
    And valido el parametro "status" tenga el contenido de cadena "<status>"
    And valido el parametro "complete" tenga el contenido booleano "<complete>"

    Examples:
      | id   |petId   | quantity | shipDate                 | codigoRespuesta | status | complete |
      | 5    | 0      | 0        | 2024-06-30T18:21:29.523Z |200              | placed | true      |
#      | 6     | 0      | 0        | 2024-06-30T18:21:29.523Z |200              | placed | true      |

