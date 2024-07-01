package com.nttdata.glue;
import com.nttdata.step.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
public class OrderDef {

    @Steps
    OrderStep order;

/*    @Given("consulto disponibilidad  del Servicio de URL_BASE  {string}")
    public void consultardisponibilidadservicio(String url) {
        order.consultardisponibilidadservicio(url);
    }


    @Given("la URL_BASE del Servicio responde {int}")
    public void validarstatusservicio(int cresp) {
        order.validarstatus(cresp);
    }
    @When("consulto el Servicio con el Path {string} y el parametro de  {int} de orden")
    public void consultarfuncionalidad(String pathh,int idparam) {
        order.consultafuncionalidad(pathh,idparam);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validartatusfuncionalidad(int cresp) {
        order.validarstatus(cresp);
    }

    @And("valido el parametro {string} tenga el contenido numerico {int}")
    public void laUrlDelServicio( String param,int paramnum) {
        order.validaparamnumerico(param,paramnum);
    }*/
@Given("consulto disponibilidad  del Servicio de URL_BASE  {string}")
public void consultoDisponibilidadDelServicioDeURL_BASE(String arg0) {
    order.consultoDisponibilidadDelServicioDeURL_BASE(arg0);
}
    @Given("la URL_BASE del Servicio responde {int}")
    public void laURL_BASEDelServicioRespondeCodigoRespuesta(int cresp) {
        order.laURL_BASEDelServicioRespondeCodigoRespuesta(cresp);
    }
    @When("consulto el Servicio con el Path {string} y el parametro de  {int} de orden")
    public void consultoElServicioConElPathYElParametroDeIdDeOrden(String pathh,int id) {
        order.consultoElServicioConElPathYElParametroDeIdDeOrden(pathh,id);

    }
    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSeaCodigoRespuesta(int cresp) {
        order.validoElCodigoDeRespuestaSeaCodigoRespuesta(cresp);
}
    @And("valido el parametro {string} tenga el contenido numerico {int}")
    public void validoElParametroTengaElContenidoNumericoId(String param,int paramnum) {
        order.validaparamnumerico(param,paramnum);

    }
    //esce 2


  @When("establezco  el Path {string}")
  public void establezcoElPath(String pathh) {
      order.establezcoElPath(pathh);
  }
    @And("creo la orden con {int},{int},{int},{string},{string},{string}")
    public void creoLaOrdenConIdPetIdQuantity(int id,int petId,int quantity,String shipDate,String status,String complete) {
        order.creoLaOrdenConIdPetIdQuantity(id, petId , quantity , shipDate , status, complete);

    }

    @And("valido el parametro {string} tenga el contenido de cadena {string}")
    public void validoElParametroTengaElContenidoDeCadena(String arg0, String arg1) {
        order.validoElParametroTengaElContenidoDeCadena(arg0,arg1);

    }

    @And("valido el parametro {string} tenga el contenido booleano {string}")
    public void validoElParametroTengaElContenidoBooleano(String arg0, String arg1) {
        order.validoElParametroTengaElContenidoBooleano(arg0,arg1);

    }



}
