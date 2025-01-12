package questions;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static util.Schemas.SEARCH_USER;

public class AskSearchUser implements Question<String> {

    public static AskSearchUser value() {
        return new AskSearchUser();
    }

    @Override
    public String answeredBy(Actor actor) {

        actor.should(
                seeThat(
                        "El codigo es el correcto",
                        question -> SerenityRest.lastResponse().statusCode(),
                        equalTo(HttpStatus.SC_OK)
                ),
                seeThat(
                        "La respuesta coincide con el schema definido",
                        question -> SerenityRest.lastResponse().asString(),
                        JsonSchemaValidator.matchesJsonSchemaInClasspath(SEARCH_USER)
                )
        );

        return SerenityRest.lastResponse().jsonPath().getString("data.first_name");
    }
}
