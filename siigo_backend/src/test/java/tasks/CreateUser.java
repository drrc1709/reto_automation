package tasks;

import interactions.userRequest.SendCreateUser;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static builders.UserRequestBuilder.buildUser;
import static enums.SessionVariables.JOB;
import static enums.SessionVariables.NAME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class CreateUser implements Task {

    private String name;
    private String job;

    public static CreateUser withData(String name, String job) {
        return instrumented(CreateUser.class, name, job);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(NAME.toString(), name);
        actor.remember(JOB.toString(), job);

        actor.attemptsTo(
                SendCreateUser.sendRequest()
        );
    }
}
