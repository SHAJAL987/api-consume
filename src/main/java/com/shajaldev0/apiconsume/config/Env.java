package com.shajaldev0.apiconsume.config;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Getter
public class Env {
    private Properties env;
    private final String CONFIG_FILE_NAME = "env.properties";
    private String envRapidHost;
    private String envRapidApiKey;
    private String envIpGeoLocationHost;
    private String envIpGeoLocationApiKey;

    private static Env envConfig;

    public static Env getInstance() {
        if(envConfig == null)
            envConfig = new Env();
        return envConfig;
    }

    public Env() {
        loadConfig();
        loadProperties();
    }

    private void loadConfig() {
        try {
            env = new Properties();

            InputStream isr = this.getClass().getResourceAsStream("/" + CONFIG_FILE_NAME);

            if (isr != null) {
                InputStreamReader isrProperties = new InputStreamReader(isr);
                try {
                    env.load(isrProperties);
                } catch (IOException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    private void loadProperties() {
        try{
            envRapidHost = env.getProperty("rapidHost");
            envRapidApiKey = env.getProperty("rapidApiKey");
            envIpGeoLocationHost = env.getProperty("ipGeoLocationHost");
            envIpGeoLocationApiKey = env.getProperty("ipGeoLocationApiKey");
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

}
