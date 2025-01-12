package util;

import org.aeonbits.owner.ConfigFactory;

public class EnvironmentDataHandler {
    private static EnvironmentConf instance = null;

    private EnvironmentDataHandler(){}

    public static EnvironmentConf get(){

        instance = ConfigFactory.create(EnvironmentConf.class);
        instance.url();

        return instance;
    }
}
