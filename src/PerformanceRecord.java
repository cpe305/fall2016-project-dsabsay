import java.util.Date;

public abstract class PerformanceRecord {
	private float totalScore;
	private int elapsedTimeSeconds;
	private Date date;
	
	public abstract void saveToDisk();
	
	public PerformanceRecord(float totalScore, Date date, int elapsedTimeSeconds) {
		this.totalScore = totalScore;
		this.date = date;
		this.elapsedTimeSeconds = elapsedTimeSeconds;
	}
}
