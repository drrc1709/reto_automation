package endpoints;

import lombok.Getter;

@Getter
public enum Endpoints {
    USER("/api/users"),
    USER_PARAM("/api/users/{id}");

    private final String path;

    Endpoints(String path){this.path = path;}

}
