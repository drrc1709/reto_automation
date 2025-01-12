package interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

@AllArgsConstructor
public class Get extends DebuggableRestInteraction{

    private final String resource;

    @Step("{0} executes the following resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (isDebuggable()){
            rest().log().all().get(as(actor).resolve(resource)).then().log().all();
        } else {
            rest().get(as(actor).resolve(resource));
        }
    }

    public static Get toResource(String resource) {
        return instrumented(Get.class, resource);
    }
}