package builders;

import model.CreateUserRequest;

public class UserRequestBuilder {

    public static CreateUserRequest buildUser(String name, String job){
        return CreateUserRequest.builder().name(name).job(job).build();
    }
}
