package pl.jsystems.qa.qaapi.author.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ApiConfig {
    private static final Config CONFIG = ConfigFactory.load("qaapiconfig.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String AZURE_BASE_PATH = ENV.getString("azureBasePath");

}
