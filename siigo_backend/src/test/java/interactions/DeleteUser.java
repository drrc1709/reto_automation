package interactions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static endpoints.Endpoints.BASE_URL;
import static endpoints.Endpoints.API_USER;
import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class DeleteUser implements Interaction {

    private Integer id;

    public static DeleteUser withData(Integer id) {
        return instrumented(DeleteUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Response response = given()
                .baseUri(BASE_URL.getPath())
                .when()
                .contentType(ContentType.JSON)
                .delete(API_USER.getPath()+ "/" + id)
                .then()
                .extract()
                .response();

        actor.remember("API_RESPONSE", response);

        Serenity.recordReportData().withTitle("Solicitud DELETE")
                .andContents("Endpoint: " + API_USER.getPath()+ "/" + id );

        Serenity.recordReportData().withTitle("Respuesta")
                .andContents("Status Code: " + response.getStatusCode()
                        + "\nResponse Body: " + response.getBody().asString());
    }
}
