package enums.environment;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum UserType {

     USER("usuario registrado en la app");

    private final String value;

    UserType(String value){ this.value = value; }

    public static UserType findUserProperty(String property){
        Map<String, UserType> valuesToMap =
                Arrays.stream(UserType.values()).parallel()
                        .collect(Collectors.toMap(UserType::getValue, e-> e));
        return valuesToMap.get(property);
    }
}