package interactions;

import model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static enums.environment.UserType.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static ui.LoginUI.*;

public class StartSession implements Interaction {

    public static Performable toClick() {
        return instrumented(StartSession.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        User user = actor.recall(USER.toString());

        actor.attemptsTo(
                WaitUntil.the(TITLE, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(user.getUser()).into(EMAIL),
                Enter.theValue(user.getPass()).into(PASSWORD),
                Click.on(SIGN_IN_BUTTON)
        );
    }
}
