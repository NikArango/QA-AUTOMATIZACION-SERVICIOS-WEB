package com.nttdata.step;
import io.cucumber.java.sl.In;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class OrderStep {

    private static String URL_BASE = null;
    private static String pathg = null;
    private static String pathp = null;
    private static int disponibilidadservicio = 0;
    private static int disponibilidadfuncionalidad = 0;
    private static int paramId = 0;

  //  Response response;

    public void consultoDisponibilidadDelServicioDeURL_BASE(String url){
        URL_BASE = url;
        Response   response =
                SerenityRest.given()
                        .contentType("application/json").log().all()
                        //.filter(new RequestLoggingFilter(requestCapture))
                        //.filter(new ResponseLoggingFilter(responseCapture))
                        //.pathParams("variable", "valoe"")
                        //.queryParam("variable", "value")
                        //.body(jsonBody.toString())
                        .when()
                        .get(URL_BASE);
        //    response.toString();

        disponibilidadservicio=  response.getStatusCode();
        // restAssuredThat(response -> response.statusCode(disponibilidadservicio));

    };

    public void  laURL_BASEDelServicioRespondeCodigoRespuesta(int cresp){
       // Assert.assertEquals(cresp, disponibilidadservicio);
        //LOGGER.info("Response StatusCode: " + response.getStatusCode());
        Assert.assertEquals(cresp, lastResponse().getStatusCode());
    };
    public void consultoElServicioConElPathYElParametroDeIdDeOrden(String pathh,int idparam){
//pathg=pathh;
       String idp= String.valueOf(idparam);
        Response   response =
                SerenityRest.given()
                        .contentType("application/json").log().all()
                        //.filter(new RequestLoggingFilter(requestCapture))
                        //.filter(new ResponseLoggingFilter(responseCapture))
                       // .pathParams("variable", idparam)
                        //.queryParam("variable", "value")
                        //.body(jsonBody.toString())
                        .when()
                        .get(URL_BASE+pathh+idp);
     /*   System.out.println("la repuesta es:::::::::::::::");
        System.out.println("*"+URL_BASE+pathh+idp+"*");*/

        // .get("https://petstore.swagger.io/v2/store/order/21");

        //    response.toString();
        disponibilidadfuncionalidad=  response.getStatusCode();
        System.out.println("la repuesta es:::::::::::::::");
        System.out.println(response.then()
                .extract().body().asString());
        System.out.println("tiempo repuesta es:::::::::::::::");

        response.then().time(lessThan(5000L));//ms


    };


    public void   validoElCodigoDeRespuestaSeaCodigoRespuesta(int cresp){
        // restAssuredThat(response -> response.statusCode(disponibilidadservicio));
        Assert.assertEquals(cresp, lastResponse().getStatusCode());

    }
    public void validaparamnumerico(String param,int paramnum){
        String resultadoReal = lastResponse().body().path(param).toString();
        System.out.println("resultadoReal"+resultadoReal);//
        Assert.assertEquals(String.valueOf(paramnum) , resultadoReal);

    };








    //post
    public void  establezcoElPath(String pathh){

        pathp=pathh;
    };
    public void  creoLaOrdenConIdPetIdQuantity(int id, int petId ,int quantity ,String shipDate ,String status,String  complete){
        Response  response=  SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body(
                        "{\n" +
                                "  \"id\": "+id+",\n" +
                                "  \"petId\": "+petId+",\n" +
                                "  \"quantity\": "+quantity+",\n" +
                                "  \"shipDate\": \""+shipDate+"\",\n" +
                                "  \"status\": \""+status+"\",\n" +
                                "  \"complete\": "+Boolean.parseBoolean(complete)+"\n" +
                                "}"


                )
                //.log().all()
                .post(URL_BASE+pathp)
               // .then()
                //.extract().body().asString()


                ;
        System.out.println("URL_BASEeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee es:::::::::::::::"+URL_BASE+pathp);

        System.out.println("codigo respuestaaaaaaaaaaaaaaaaaaaaaaaaaaaaa es:::::::::::::::"+response.getStatusCode());
        System.out.println(response.then()
                .extract().body().asString());

        System.out.println("tiempo repuesta es:::::::::::::::");

        response.then().time(lessThan(5000L));//ms

        ;

    };

    public void validoElParametroTengaElContenidoDeCadena(String param,String paramstring){
        String resultadoReal = lastResponse().body().path(param).toString();
        System.out.println(resultadoReal);//
        Assert.assertEquals(paramstring , resultadoReal);

    };

    public void validoElParametroTengaElContenidoBooleano(String param,String parambool){
        String resultadoReal = lastResponse().body().path(param).toString();
        System.out.println(resultadoReal);//
        Assert.assertEquals(parambool, resultadoReal);

    };




}
