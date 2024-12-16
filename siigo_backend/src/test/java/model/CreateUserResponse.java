package model;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String id;
    private String name;
    private String job;
    private String createdAt;
}
