package questions;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static util.Schemas.CREATE_USER;

public class AskCreatedUser implements Question<String> {

    public static AskCreatedUser id() {
        return new AskCreatedUser();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.should(
                seeThat(
                        "El recurso fue creado",
                        question -> SerenityRest.lastResponse().statusCode(),
                        equalTo(HttpStatus.SC_CREATED)
                ),
                seeThat(
                        "La respuesta coincide con el schema definido",
                        question -> SerenityRest.lastResponse().asString(),
                        JsonSchemaValidator.matchesJsonSchemaInClasspath(CREATE_USER)
                )
        );

        return SerenityRest.lastResponse().jsonPath().getString("id");
    }
}
