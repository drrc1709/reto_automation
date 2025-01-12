package questions;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static util.Schemas.UPDATE_USER;

public class AskUpdatedUser implements Question<String> {

    public static AskUpdatedUser value() {
        return new AskUpdatedUser();
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
                        JsonSchemaValidator.matchesJsonSchemaInClasspath(UPDATE_USER)
                )
        );

        return SerenityRest.lastResponse().jsonPath().getString("job");
    }
}