package interactions.userRequest;

import interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static builders.UserRequestBuilder.buildUser;
import static endpoints.Endpoints.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SendCreateUser implements Interaction {

    public static Performable sendRequest(){
        return instrumented(SendCreateUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Post.toResource(USER.getPath())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(buildUser())
                        )
        );
    }
}
