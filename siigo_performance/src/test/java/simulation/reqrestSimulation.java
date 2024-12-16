package simulation;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class reqrestSimulation extends Simulation {

    private static final String CREATE_URL = "/api/users";

    FeederBuilder<String> users = csv("data/users.csv").circular();

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("https://reqres.in/");

    ChainBuilder createStep = feed(users)
            .exec(http("Create User")
            .post(CREATE_URL)
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .body(StringBody("{\"name\": \"#{name}\" ,\"job\": \"#{job}\"}"))
                    .check(status().is(201))
                    .check(jsonPath("$.id"))
    );

    ScenarioBuilder createUserScenario = scenario("Crear Usuario")
            .exec(createStep);

    {
        setUp(
                createUserScenario.injectOpen(nothingFor(5),
                        rampUsers(10).during(20),
                        constantUsersPerSec(20).during(30),
                        rampUsers(50).during(40))
        ).protocols(httpProtocol);
    }
}
