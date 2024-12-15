package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.ProfileUI.CLIENTS;
import static ui.ProfileUI.CREATE;

public class NewClient implements Interaction {

    public static Performable toClick() {
        return instrumented(NewClient.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CREATE),
                Click.on(CLIENTS)
        );
    }
}
