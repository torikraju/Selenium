package Framework.Loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigLoader {


    private static String configProperties = "resources/config.properties";

    public static String getPropertiesById(String name) {
        return getPropertiesById(name, null);
    }

    public static String getPropertiesById(String name, String defaultData) {
        Properties properties = new Properties();
        File file = new File(configProperties);
        if (!file.exists()) {
            return defaultData;
        } else {
            try {
                InputStream inputStream = new FileInputStream(file);
                properties.load(inputStream);
                inputStream.close();
                return properties.getProperty(name, defaultData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return defaultData;
    }

}
