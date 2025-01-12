package util;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:test.properties"})
public interface EnvironmentConf extends Config {
    String url();
}
