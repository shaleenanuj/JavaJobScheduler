package javaJobScheduler;
import java.util.Set;
import java.time.LocalTime;
/* Schedule class contains the information of schedule of
 * any Job
 */
class Schedule {
	public Schedule(Set<LocalTime> dateTimeSet) {
		super();
		this.dateTimeSet = dateTimeSet;
	}

	Set<LocalTime> dateTimeSet;

	/**
	 * @return the dateTimeSet
	 */
	public Set<LocalTime> getDateTimeSet() {
		return dateTimeSet;
	}

	/**
	 * @param dateTimeSet the dateTimeSet to set
	 */
	public void setDateTimeSet(Set<LocalTime> dateTimeSet) {
		this.dateTimeSet = dateTimeSet;
	}
	
}
