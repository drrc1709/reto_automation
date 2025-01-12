package interactions;

import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.model.util.EnvironmentVariables;

abstract class DebuggableRestInteraction extends RestInteraction {

    private EnvironmentVariables environmentVariables;

    boolean isDebuggable(){
        return environmentVariables.getPropertyAsBoolean("debug.rest.queries", false);
    }

}
