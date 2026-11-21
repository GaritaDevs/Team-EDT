package com.teamProj.util;

import java.io.IOException;
import java.util.Properties;


/**
 * The interface Properties loader.
 */
public interface PropertiesLoader {

    /**
     * Load properties.
     *
     * @param propertiesFilePath the properties file path
     * @return the properties
     */
    default Properties loadProperties(String propertiesFilePath){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            System.out.println("There was a problem reading the properties file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem...");
            exception.printStackTrace();
        }
        return properties;
    }
}
