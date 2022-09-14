import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

public class Settings {
    //properties keys
    public static final String LANGUAGE_PROPERTIES_KEY = "LanValuesPath";
    public static final String HISTORY_ENABLED_KEY = "HistoryTrackingEnabled";

    Properties setUp(Locale userLocale) {
        Properties properties;
        File settingsFile = new File(Main.SETTINGS_PATH);
        File lanValues = new File(this.getLanguageValuesLocation(userLocale));

        if(!settingsFile.exists()){
            if(!lanValues.exists()){
                throw new RuntimeException("The file \"strings.xml\" is missing");
            }

            properties = this.init(lanValues.getPath());
        } else {
            properties = this.loadConfigurations();
        }

        return properties;
    }

    Properties init(String lanFilePath) {
        /*Creates a settings file and configurations when the app was first time started*/
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

    String getLanguageValuesLocation(Locale lan) {
        switch (lan.getLanguage()) {
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

    void writeActionDownToFile(String newRecord){
        try{
            FileWriter w = new FileWriter(Main.HISTORY_FILE_PATH, true);
            w.append(newRecord);
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String buildHistoryOutput(ArrayList<String> log){
        StringBuilder history = new StringBuilder();

        for(int i = log.size() - 1; i >= 0; i--){
            history.append(log.get(i)).append("\n");
        }
        return history.toString();
    }

    String buildHistoryRecord(int firstNumber, int systemOfFirstNumber, String action, int secondNumber,
                int systemOfSecondNumber, int result, int systemOfResult){
        //this builder is for common math section

        return firstNumber + "(" + systemOfFirstNumber + ")" + action + secondNumber +
                "(" + systemOfSecondNumber + ")" + "=" + result + "(" + systemOfResult + ")";
    }
    String buildHistoryRecord(int numberToConvert, int systemOfNumber, int result, int systemOfResult ){
        //this builder is for converter section

        return numberToConvert + "(" + systemOfNumber + ")" + ">>" + result + "(" + systemOfResult + ")";
    }

    ArrayList<String> removeLastRecord(ArrayList<String> log){
        log.remove(log.size() - 1);

        try{
            this.clearHistoryFile();

            FileWriter w = new FileWriter(Main.HISTORY_FILE_PATH, true);
            for(String record: log){
                w.write(record);
            }
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return log;
    }

    ArrayList<String> clearHistory(ArrayList<String> log){
        log.clear();
        this.clearHistoryFile();

        return log;
    }

    void clearHistoryFile(){
        try{
            FileWriter cleaner = new FileWriter(Main.HISTORY_FILE_PATH);
            cleaner.write("");
            cleaner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
