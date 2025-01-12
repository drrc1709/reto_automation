package interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

@AllArgsConstructor
public class Put extends DebuggableRestInteraction{

    private final String resource;

    @Step("{0} executes the following resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (isDebuggable()){
            rest().log().all().put(as(actor).resolve(resource)).then().log().all();
        } else {
            rest().put(as(actor).resolve(resource));
        }
    }

    public static Put toResource(String resource) {
        return instrumented(Put.class, resource);
    }
}

