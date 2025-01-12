package interactions.userRequest;

import interactions.Delete;
import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static endpoints.Endpoints.USER_PARAM;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class DeleteUser implements Interaction {

    private Integer id;

    public static DeleteUser withData(Integer id) {
        return instrumented(DeleteUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.toResource(USER_PARAM.getPath())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .pathParam("id", id)
                        )
        );
    }
}
