package endpoints;

import lombok.Getter;

@Getter
public enum Endpoints {
    BASE_URL("https://reqres.in"),
    API_USER("/api/users");

    private final String path;

    Endpoints(String path){this.path = path;}

}
