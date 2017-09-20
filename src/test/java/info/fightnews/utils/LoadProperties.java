package info.fightnews.utils;

import java.io.*;
import java.util.Properties;

/**
 * Created by mlukianenko on 5/5/17.
 */
public class LoadProperties {
    private static Properties configProp = new Properties();

    public static Properties getConfig() {
        if (configProp.size() == 0) {
            String env = System.getProperty("env","stage");
            if (env != null) {
                loadProps(env);
            }
        }
        return configProp;
    }

    private static void loadProps(String env) {
        try {
            InputStream input = new FileInputStream("src/test/resources/" + env + "_config.properties");
            configProp.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}