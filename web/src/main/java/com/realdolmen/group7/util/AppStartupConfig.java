package com.realdolmen.group7.util;

import com.realdolmen.group7.controller.exceptionHandler.ConfigException;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ESOBG49 on 12/11/2017.
 */
@Startup
@Singleton
public class AppStartupConfig {

    private final String CONFIGPROPERTIESNAME = "AppConfig.properties"; // Name of the .properties file we're using to configure our app.
    private final String CONFIGPROPERTIESPATH = "C:/Project/"; // directory path of where the .properties file is located
    private File propertiesFile;
    private Properties properties = new Properties();

    public static double marginPercentage = 0;



    public AppStartupConfig() throws ConfigException {
        propertiesFile = new File(CONFIGPROPERTIESPATH+CONFIGPROPERTIESNAME);
        readProperties();
    }



    private void readProperties() throws ConfigException {

        try (FileInputStream fileInputStream = new FileInputStream(propertiesFile)){
            properties.load(fileInputStream);

            getConfigurations();

        } catch (FileNotFoundException ex) {
            throw new ConfigException(ex.getMessage()+"\nThe configuration properties file is missing.\nIt is expected to be located at: "+CONFIGPROPERTIESPATH+CONFIGPROPERTIESNAME);
        } catch (IOException e) {
            throw new ConfigException(e.getMessage()+"\nThe configuration properties file is missing.\nIt is expected to be located at: "+CONFIGPROPERTIESPATH+CONFIGPROPERTIESNAME);
        }
    }



    private void getConfigurations(){
        String marginPercentageString = properties.getProperty("marginPercentage","25");


        try {
            marginPercentage = Double.parseDouble(marginPercentageString);
        } catch (Exception e) {
            marginPercentage = 25D;
        }
    }




}
