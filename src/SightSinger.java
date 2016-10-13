import java.util.Date;

public class SightSinger {
	public static void main(String args[]) throws Throwable{
		System.out.println("SightSinger");

      ProgressTracker pt = new ProgressTracker();
      PerformanceRecord pr = new SightSingingRecord(
            2, 
            "melodytype", 
            2.4f, 
            2.1f, 
            2.2f, 
            new Date(), 
            29);
      try {
         pt.savePerformanceRecord(pr);
      } catch (Throwable e) {

      }


      PerformanceRecord r = pt.getSightSingingRecords();

      System.out.println(r);





	}
}
