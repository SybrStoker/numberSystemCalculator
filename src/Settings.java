import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    public static final String LANGUAGE_PROPERTIES_KEY = "LanValuesPath";
    public static final String HISTORY_ENABLED_KEY = "HistoryEnabled";
    public static final String[] LOCALE_STORE = {"en", "de", "ru"};

    Properties setUp() {
        Properties properties;
        File settingsFile = new File(Main.SETTINGS_PATH);
        File lanValues = new File(this.getLanguageValuesLocation(System.getProperty("user.language")));

        if(!settingsFile.exists()){
            properties = this.init(lanValues.getPath());
        } else {
            properties = this.loadConfigurations();
        }

        return properties;
    }

    Properties init(String lanFilePath) {
        /*Creates a settings file and configurations*/
        FileWriter w;
        Properties properties = new Properties();

        //Default configurations:
        properties.setProperty(Settings.LANGUAGE_PROPERTIES_KEY, lanFilePath);
        properties.setProperty(Settings.HISTORY_ENABLED_KEY, "true");

        try {
            w = new FileWriter(Main.SETTINGS_PATH);
            properties.store(w, "WARNING! Don't edit manually!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    String getLanguageValuesLocation(String language) {
        switch (language) {
            case "ru" -> {
                return Main.FILE_NAME_RU;
            } case "de" -> {
                return Main.FILE_NAME_DE;
            } default -> {
                return Main.FILE_NAME;
            }
        }
    }

    Properties loadConfigurations() {
        FileReader r;
        Properties properties = new Properties();

        try{
            r = new FileReader(Main.SETTINGS_PATH);
            properties.load(r);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    Properties editConfigurations(Properties properties, String key, String newValue){
        properties.replace(key, newValue);

        return properties;
    }
}
