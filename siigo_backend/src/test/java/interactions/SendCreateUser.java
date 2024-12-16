package interactions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import model.CreateUserRequest;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;


import static endpoints.Endpoints.BASE_URL;
import static endpoints.Endpoints.API_USER;
import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class SendCreateUser implements Interaction {

    private final CreateUserRequest usersRequest;

    public static Performable sendRequest(CreateUserRequest usersRequest){
        return instrumented(SendCreateUser.class, usersRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Response response = given()
                .body(usersRequest)
                .baseUri(BASE_URL.getPath())
                .when()
                .contentType(ContentType.JSON)
                .post(API_USER.getPath())
                .then()
                .extract()
                .response();

        actor.remember("API_RESPONSE", response);

        Serenity.recordReportData().withTitle("Solicitud POST")
                .andContents("Endpoint: " + API_USER.getPath() + "\nBody: " + usersRequest.toString());

        Serenity.recordReportData().withTitle("Respuesta")
                .andContents("Status Code: " + response.getStatusCode()
                        + "\nResponse Body: " + response.getBody().asString());
    }
}
