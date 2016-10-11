import java.util.Date;

public class SightSingingRecord 
	extends PerformanceRecord {
	private int melodyID;
	private String melodyType;
	private float pitchScore;
	private float rhythmScore;
	private final String performanceType = "sightsinging";
	
	public SightSingingRecord(int melodyID, String melodyType, float totalScore,
			float pitchScore, float rhythmScore, Date date, int elapsedTimeSeconds) {
		super(totalScore, date, elapsedTimeSeconds);
		this.melodyID = melodyID;
		this.melodyType = melodyType;
		this.pitchScore = pitchScore;
		this.rhythmScore = rhythmScore;
	}
	
	public void saveToDisk() {
		//you can get the path from settings
	}
}
