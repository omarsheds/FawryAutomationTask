package utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        properties = PropertiesUtils.loadProperties("src/test/java/config/testing.properties");
    }

    public static ConfigUtils getInstanceofConfigUtils() {
        if(configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the base url in the property file ");
    }

    public String getEmailOrNumber() {
        String prop = properties.getProperty("emailOrNumber");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the email in the property file ");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }

    public String fullName() {
        String prop = properties.getProperty("fullName");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }

    public String phoneNumber() {
        String prop = properties.getProperty("phoneNumber");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }

    public String streetName() {
        String prop = properties.getProperty("streetname");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }

    public String buildingNumber() {
        String prop = properties.getProperty("Buildingnumber");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }

    public String city() {
        String prop = properties.getProperty("city");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }

    public String district() {
        String prop = properties.getProperty("district");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }

    public String landmark() {
        String prop = properties.getProperty("landmark");
        if(prop != null) { return prop; }
        throw new RuntimeException("Couldn't Find the password in the property file ");
    }




}
