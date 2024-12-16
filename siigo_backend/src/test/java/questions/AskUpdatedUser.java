package questions;

import io.restassured.response.Response;
import model.CreateUserResponse;
import model.UpdateUserResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AskUpdatedUser implements Question<String> {

    public static AskUpdatedUser value() {
        return new AskUpdatedUser();
    }

    @Override
    public String answeredBy(Actor actor) {
        Response response = actor.recall("API_RESPONSE");

        if (response.getStatusCode() != 200) {
            throw new AssertionError("Error: El código de respuesta no es 200, fue: " + response.getStatusCode());
        }

        UpdateUserResponse updateUserResponse = response.body().as(UpdateUserResponse.class);
        return updateUserResponse.getJob();
    }
}