package questions;

import io.restassured.response.Response;
import model.CreateUserResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AskCreatedUser implements Question<String> {

    public static AskCreatedUser id() {
        return new AskCreatedUser();
    }

    @Override
    public String answeredBy(Actor actor) {
        Response response = actor.recall("API_RESPONSE");

        if (response.getStatusCode() != 201) {
            throw new AssertionError("Error: El código de respuesta no es 201. Es: " + response.getStatusCode());
        }

        CreateUserResponse userResponse = response.body().as(CreateUserResponse.class);
        return userResponse.getId();
    }
}
