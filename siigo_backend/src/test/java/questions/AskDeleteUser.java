package questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AskDeleteUser implements Question<Integer> {

    public static AskDeleteUser statusCode() {
        return new AskDeleteUser();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        Response response = actor.recall("API_RESPONSE");
        return response.getStatusCode();
    }
}
