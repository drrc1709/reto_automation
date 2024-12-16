package stepDefinitions;


import enums.data.SessionVariables;
import enums.environment.UserType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import tasks.Login;
import util.UserUtil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static questions.AskWelcomeMessage.textFrom;
import static ui.ProfileUI.AUTHENTICATED_USER;
import static util.environment.EnvironmentDataHandler.get;

public class StepDefinitions {

    @Given("{actor} es un {}")
    public void isAnUserRegistered(Actor actor, String userType) {
        actor.attemptsTo(Open.url(get().url()));

        UserType user = UserType.findUserProperty(userType);
        actor.remember(SessionVariables.USER.toString(), UserUtil.get(user));
    }

    @When("{actor} inicia sesión")
    public void isLoggedIn(Actor actor) {
        actor.attemptsTo(
                Login.forTheTerm()
        );
    }

    @Then("{actor} puede ver en el dashboard el usuario {string}")
    public void verifyLoginSuccess(Actor actor, String message) {
        actor.should(
                seeThat("El ve las opciones relacionadas con su perfil habilitadas",
                        textFrom(AUTHENTICATED_USER),
                        equalTo(message)
                ));
    }
}
