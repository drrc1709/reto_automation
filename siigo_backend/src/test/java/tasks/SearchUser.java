package tasks;

import interactions.GetUser;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class SearchUser implements Task {

    private Integer id;

    public static SearchUser withData(Integer id) {
        return instrumented(SearchUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetUser.withId(id)
        );
    }
}
