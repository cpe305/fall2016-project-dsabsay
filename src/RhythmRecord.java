import java.util.Date;

public class RhythmRecord 
	extends PerformanceRecord {
	private int rhythmID;
	private String rhythmType;
	private float totalScore;
	private float rhythmScore;
	private final String performanceType = "rhythm";
	
	public RhythmRecord(int rhythmID, String rhythmType, float totalScore,
			float rhythmScore, Date date, int elapsedTimeSeconds) {
		super(totalScore, date, elapsedTimeSeconds);
		this.rhythmID = rhythmID;
		this.rhythmType = rhythmType;
		this.totalScore = totalScore;
		this.rhythmScore = rhythmScore;
	}
	
	public void saveToDisk() {
		//you can get the path from settings
	}
}
