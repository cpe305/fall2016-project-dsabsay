import java.util.HashMap;

/*
 * Stores information about the user's configuration.
 * This information will be read from the disk when the application is loaded.
 */
public class UserConfiguration {
	private HashMap<String, String> melodyTypes;
	private HashMap<String, String> rhythmTypes;
	private String sightSingingRecordsPath;
	private String rhythmRecordsPath;
}
