package tasks;

import interactions.userRequest.DeleteUser;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class DeleteUserById implements Task {

    private Integer id;

    public static DeleteUserById withId(Integer id) {
        return instrumented(DeleteUserById.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DeleteUser.withData(id)
        );
    }
}
