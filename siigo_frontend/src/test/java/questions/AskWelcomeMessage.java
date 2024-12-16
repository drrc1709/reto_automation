package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class AskWelcomeMessage implements Question<String> {

    private final Target messageTarget;

    public static AskWelcomeMessage textFrom(Target messageTarget) {
        return new AskWelcomeMessage(messageTarget);
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(messageTarget, isVisible()).forNoMoreThan(20).seconds()
        );

        return TextContent.of(messageTarget).answeredBy(actor).trim();
    }
}