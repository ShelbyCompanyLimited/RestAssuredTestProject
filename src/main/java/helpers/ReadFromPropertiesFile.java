package helpers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {


    public Properties properties;
    String currentDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\settings.properties";
    public final String propertyFilePath = currentDirectory;


    public ReadFromPropertiesFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getEmail() {
        String username = properties.getProperty("email");
        if (username != null) return username;
        else throw new RuntimeException("Email is not specified in Property File");
    }

    public String getHostName() {
        String username = properties.getProperty("hostName");
        if (username != null) return username;
        else throw new RuntimeException("HostName is not specified in Property File");
    }

    public String getRegisterErrorMessage() {
        String registerErrorMessage = properties.getProperty("registerErrorMessage");
        if (registerErrorMessage != null) return registerErrorMessage;
        else throw new RuntimeException("Register Error Message is not specified in Property File");
    }

    public int getUserIdForDelete() {
        String userIdForDelete = properties.getProperty("userIdForDelete");
        if (userIdForDelete != null) return Integer.parseInt(userIdForDelete);
        else throw new RuntimeException("UserIdForDelete Error Message is not specified in Property File");
    }

    public int getPositiveDelay() {
        String positiveDelay = properties.getProperty("positiveDelay");
        if (positiveDelay != null) return Integer.parseInt(positiveDelay);
        else throw new RuntimeException("positiveDelay Error Message is not specified in Property File");
    }

    public int getNegativeDelay() {
        String negativeDelay = properties.getProperty("negativeDelay");
        if (negativeDelay != null) return Integer.parseInt(negativeDelay);
        else throw new RuntimeException("negativeDelay Error Message is not specified in Property File");
    }
    public String getPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("Password is not specified in Property File");
    }
    public String getRegisterErrorMessageWithPassword() {
        String registerErrorMessageWithPassword = properties.getProperty("registerErrorMessageWithPassword");
        if (registerErrorMessageWithPassword != null) return registerErrorMessageWithPassword;
        else throw new RuntimeException("RegisterErrorMessageWithPassword is not specified in Property File");
    }

}