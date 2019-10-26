import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DayTimeTwo {
	LocalDateTime curTime;

	public DayTimeTwo() {
		// TODO Auto-generated constructor 
	}
	
	public void daysOfCurrentMonth() {
		Calendar cal = new GregorianCalendar();
		cal = cal.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 10);
		String tenthDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		cal.set(Calendar.DAY_OF_MONTH, 18);
		String eighteenthDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthDay);
	}
	
	public void daysOfAnyMonth(int month, int year){
		String month 
	}
	
	public void compareYear() {
		
	}
	
	public void dateHashMap() {
		
	}
	
	public void dateHashMapSorted() {
		
	}
	
	

}
