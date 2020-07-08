package javaJobScheduler;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class SchedulerDriver {

	public static void main(String[] args) {
		int i;
		
		Set<LocalTime> timeSet = new HashSet<LocalTime>();
		
		
		//Job1: type Job1
		LocalTime lt = LocalTime.now();
		for(i=1;i<10;i++) {
			timeSet.add((between(lt,lt.plusMinutes(20))));
		}
		Schedule s1 = new Schedule(timeSet);
		Runnable j1 = new JobType1(s1,1);
		
		
		//Job 2: Type 2
		Set<LocalTime> timeSet2 = new HashSet<LocalTime>();
		for(i=1;i<10;i++) {
			timeSet2.add((between(lt,lt.plusMinutes(30))));
		}
		Schedule s2 = new Schedule(timeSet2);
		Runnable j2 = new JobType2(s2,2);
		
		/*The following code will call the jobs on fixed interval we can also implement it calling as per
		 * the schedule using Duration period = Duration.between(myDateObj, myDateObj1);
		 * where myDateObj and myDateObj1 are 2 consecutive timestamps in the schedule
		 * and then by calling 
		 * 
		 * ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);            
scheduler.scheduleAtFixedRate(new MyRunnableTask(),
    duration,
    TimeUnit.DAYS.toSeconds(1),
    TimeUnit.SECONDS);
		 */
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		ScheduledFuture<?> jobHandler = scheduler.scheduleAtFixedRate(j1, 10, 10, TimeUnit.SECONDS);
		
		scheduler.schedule(new Runnable() {
		       public void run() { jobHandler.cancel(true); }
		     }, 60 * 60, TimeUnit.SECONDS);
		
		
	    
		ScheduledFuture<?> jobHandler2 = scheduler.scheduleAtFixedRate(j2, 10, 10, TimeUnit.SECONDS);
		
		scheduler.schedule(new Runnable() {
		       public void run() { jobHandler2.cancel(true); }
		     }, 60 * 60, TimeUnit.SECONDS);
		

	}
	
	
	public static LocalTime between(LocalTime startTime, LocalTime endTime) {
	    int startSeconds = startTime.toSecondOfDay();
	    int endSeconds = endTime.toSecondOfDay();
	    int randomTime = ThreadLocalRandom
	      .current()
	      .nextInt(startSeconds, endSeconds);
	 
	    return LocalTime.ofSecondOfDay(randomTime);
	}


}
