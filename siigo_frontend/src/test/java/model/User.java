package model;

import enums.environment.UserType;
import lombok.Data;

@Data
public class User {
    private String user;
    private String pass;
    private UserType userType;
}
