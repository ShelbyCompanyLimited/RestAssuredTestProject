package bots;

import helpers.ReadFromPropertiesFile;

public class BaseServiceExtender {

    public static ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();

    static String hostName = readFromPropertiesFile.getHostName();
    static String usersService = "users";
    static String registerService = "register";

    public String getHostname() {
        return hostName;
    }

    public String getUserService() {
        return usersService;
    }

    public String getRegisterService() {
        return registerService;
    }
}