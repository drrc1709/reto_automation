package model;

import lombok.Data;

@Data
public class SearchUserResponse {
    private DataInfo data;
    private Support support;

    @Data
    public static class DataInfo {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Data
    public static class Support {
        private String url;
        private String text;
    }
}
