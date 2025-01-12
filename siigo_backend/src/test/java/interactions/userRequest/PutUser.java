package interactions.userRequest;

import interactions.Delete;
import interactions.Put;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import model.CreateUserRequest;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static builders.UserRequestBuilder.buildUser;
import static endpoints.Endpoints.*;
import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class PutUser implements Interaction {

    private Integer id;

    public static PutUser withId(Integer id) {
        return instrumented(PutUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Put.toResource(USER_PARAM.getPath())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .pathParam("id", id)
                                .body(buildUser())
                        )
        );
    }
}
