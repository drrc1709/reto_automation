package interactions.userRequest;

import interactions.Delete;
import interactions.Get;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static endpoints.Endpoints.*;
import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class GetUser implements Interaction {

    private Integer id;

    public static GetUser withId(Integer id) {
        return instrumented(GetUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.toResource(USER_PARAM.getPath())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .pathParam("id", id)
                        )
        );
    }
}
