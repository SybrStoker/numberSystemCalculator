import java.util.Locale;

public class Main {
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String RESOURCES_PATH = "." + SEPARATOR + "res" + SEPARATOR;
    public static final String END_OF_PATH = SEPARATOR + "strings.xml";

    public static final String SETTINGS_PATH = RESOURCES_PATH + "config.properties";
    public static final String HISTORY_FILE_PATH = RESOURCES_PATH + "history.txt";
    public static final String FILE_NAME = RESOURCES_PATH + "values" + END_OF_PATH;
    public static final String FILE_NAME_RU = RESOURCES_PATH + "values_ru" + END_OF_PATH;
    public static final String FILE_NAME_DE = RESOURCES_PATH + "values_de" + END_OF_PATH;
    public static void main(String[] args) {
        Settings toolKit = new Settings();
        toolKit.setUp(new Locale(System.getProperty("user.language")));

        new Menu();
    }
}
