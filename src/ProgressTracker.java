import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Handles reading and writing user progress and statistics */
public class ProgressTracker {
	private UserConfiguration settings;
	
	//the path where the records will be written to will be stored in the settings object
	public void savePerformanceRecord(PerformanceRecord record) {
		
	}
	
	//Read all SightSingingRecords from disk into a List
	public List<SightSingingRecord> getSightSingingRecords() {
		return new ArrayList<SightSingingRecord>();
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
