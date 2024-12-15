package util;
import com.google.gson.Gson;
import enums.environment.UserType;
import model.User;
import util.environment.EnvironmentDataHandler;

import java.util.EnumMap;
import java.util.NoSuchElementException;

public class UserUtil {

    private static final Gson jsonConverter = new Gson();

    private UserUtil() {}

    static final EnumMap<UserType, String> userTypeMap = new EnumMap<>(UserType.class);

    static {
        userTypeMap.put(UserType.USER,
                EnvironmentDataHandler.get().user());

    }

    public static User get(UserType userType) {
        User user = jsonConverter.fromJson(userTypeMap.get(userType), User.class);

        if (user == null) {
            throw new NoSuchElementException(String.format("User type %s not found", userType));
        }

        user.setUserType(userType);

        return user;
    }
}