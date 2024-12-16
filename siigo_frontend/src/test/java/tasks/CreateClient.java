package tasks;

import interactions.NewClient;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateClient implements Task {

    public static Performable toClick() {
        return instrumented(CreateClient.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                NewClient.toClick()
        );

    }
}
