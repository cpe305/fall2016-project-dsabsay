import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;


/* Handles reading and writing user progress and statistics */
public class ProgressTracker {
	private UserConfiguration settings;
	
	//the path where the records will be written to will be stored in the settings object
	public void savePerformanceRecord(PerformanceRecord record) throws IOException {
      //Needs settings config file to be implemented 
      //File db = new File(settings.dbfile);
      try {
         File db = new File("my-db.db");
         ObjectOutputStream oos = null; 
         oos = new ObjectOutputStream(new FileOutputStream(db));
         oos.writeObject(record);
         oos.close();
      } catch(Throwable e) {

      }
	}
	
	//Read all SightSingingRecords from disk into a List
	public SightSingingRecord getSightSingingRecords() throws Throwable {
      SightSingingRecord ssr = null;
      InputStream db = new FileInputStream("my-db.db");
      InputStream buffer = new BufferedInputStream(db);
      ObjectInputStream input = new ObjectInputStream(buffer);
      ssr = (SightSingingRecord) input.readObject();
      System.out.println(ssr);
      return ssr;

		//return new ArrayList<SightSingingRecord>();
	}
	
	//Read all RhythmRecords from disk into a List
	public List<RhythmRecord> getRhythmRecords() {
		return new ArrayList<RhythmRecord>();
	}
	
	//Reads sight singing records from file into hash map <Key: melody category, Value: list of records
	public HashMap<String, List<SightSingingRecord>> readSightSingingRecords() {
		return new HashMap<String, List<SightSingingRecord>>();
	}
	
	//Reads rhythm records from file into hash map <Key: rhythm category, Value: list of records
	public HashMap<String, List<RhythmRecord>> readRhythmRecords() {
		return new HashMap<String, List<RhythmRecord>>();
	}
	
}
