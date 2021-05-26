package hw5.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static final String PROP = "src/test/resources/hw5/prop.properties";

    public static String getProperty(String property) {
        try (InputStream input = new FileInputStream(PROP)) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(property));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
