package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import questions.AskCreatedUser;
import questions.AskSearchUser;
import questions.AskUpdatedUser;
import tasks.CreateUser;
import tasks.DeleteUserById;
import tasks.SearchUser;
import tasks.UpdateUser;
import util.EnvironmentDataHandler;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserStepDefinition {

    @Given("{actor} ingresa a la aplicacion")
    public void enterTheApp(Actor actor) {
        actor.can(CallAnApi.at(EnvironmentDataHandler.get().url()));
    }

    @When("{actor} crea un usuario con nombre {string} y trabajo {string}")
    public void createUser(Actor actor, String name, String job) {
        actor.attemptsTo(
                CreateUser.withData(name, job)
        );
    }

    @When("{actor} consulta el usuario por {int}")
    public void searchUser(Actor actor, int id) {
        actor.attemptsTo(
                SearchUser.withData(id)
        );
    }

    @When("{actor} actualiza el trabajo {string} del usuario {string} con {int}")
    public void updateJobUser(Actor actor, String job, String name, int id) {
        actor.attemptsTo(
                UpdateUser.withData(job, name, id)
        );
    }

    @When("{actor} elimna el usuario con id {int}")
    public void deleteUser(Actor actor, int id) {
        actor.attemptsTo(DeleteUserById.withId(id));
    }

    @Then("{actor} usuario se creo exitosamente")
    public void validateUserCreated(Actor actor) {
        actor.should(
                seeThat("El usuario fue creado", AskCreatedUser.id(), notNullValue())
        );
    }

    @Then("{actor} ve la informacion del usuario {string}")
    public void seeUserInfo(Actor actor, String name) {
        actor.should(
                seeThat("el usuario fue encontrado", AskSearchUser.value(), equalTo(name))
        );
    }

    @Then("{actor} ve que el nuevo trabajo {string} fue actualizado")
    public void seeTheDataUpdated(Actor actor, String job) {
        actor.should(
                seeThat("Usuario actualizado", AskUpdatedUser.value(), equalTo(job))
        );
    }

    @Then("{actor} ve que el usuario fue eliminado")
    public void seeDeletedUser(Actor actor) {
        actor.should(
                seeThat(
                        "El usuario fue eliminado",
                        question -> SerenityRest.lastResponse().statusCode(),
                        equalTo(HttpStatus.SC_NO_CONTENT)
                )
        );
    }
}
