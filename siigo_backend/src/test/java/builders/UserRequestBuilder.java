package builders;

import model.CreateUserRequest;

import static enums.SessionVariables.JOB;
import static enums.SessionVariables.NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UserRequestBuilder {

    public static CreateUserRequest buildUser(){
        String name = theActorInTheSpotlight().recall(NAME.toString());
        String job = theActorInTheSpotlight().recall(JOB.toString());

        return CreateUserRequest.builder().name(name).job(job).build();
    }
}
