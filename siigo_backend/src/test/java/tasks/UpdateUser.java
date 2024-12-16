package tasks;

import interactions.PutUser;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static builders.UserRequestBuilder.buildUser;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class UpdateUser implements Task {

    private String job;
    private String name;
    private Integer id;

    public static UpdateUser withData(String job, String name, Integer id) {
        return instrumented(UpdateUser.class, job, name, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutUser.withId(id, buildUser(name, job))
        );
    }
}
