package questions;

import io.restassured.response.Response;
import model.SearchUserResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AskSearchUser implements Question<String> {

    public static AskSearchUser value() {
        return new AskSearchUser();
    }

    @Override
    public String answeredBy(Actor actor) {
        Response response = actor.recall("API_RESPONSE");

        if (response.getStatusCode() != 200) {
            throw new AssertionError("Error: Código de respuesta no es 200, fue: " + response.getStatusCode());
        }

        SearchUserResponse userData = response.body().as(SearchUserResponse.class);

        return userData.getData().getFirst_name();
    }
}
