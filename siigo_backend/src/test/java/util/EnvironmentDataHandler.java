package util;

import net.thucydides.model.util.EnvironmentVariables;

public class EnvironmentDataHandler {
    private static EnvironmentVariables environmentVariables;

    public static String getBaseUrl() {
        return environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in");
    }
}
