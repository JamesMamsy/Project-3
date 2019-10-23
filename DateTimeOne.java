import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.time.*;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	LocalDateTime curTime;
	/**
	 * Returns second value of system time as INT
	 */
	int getValueOfSecond() {
		return LocalDateTime.now().getSecond();
	}
	
	/**
	 * Prints the present date/time as:"Current Date/Time: month/day/year hour:minute am/pm"
	 */
	void dateTimeNow() {
		String end;
		curTime = LocalDateTime.now();
		String month = curTime.getMonth().name();
		
		int day = curTime.getDayOfMonth();
		int year = curTime.getYear();
		int hour = curTime.getHour();
		
		if(hour > 12) {
			hour = hour % 12;
			end = "pm";
		}
		else {
			end = "am";
		}
		
		int minute = curTime.getMinute();
		
		String res = String.format("Current Date/Time: %s/%d/%d %d:%d %s", month,day,year,hour,minute,end);
		
		System.out.println(res);
	}
	
	void sleepForFiveSec() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	void dateTimeOfOtherCity(){
		curTime = LocalDateTime.now();
		int curHour = curTime.getHour();
		int curMin = curTime.getMinute();
		
		GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		int gmtHour = cal.getTime().getHours();
		int gmtMin = cal.getTime().getMinutes();
		cal.setTimeZone(TimeZone.getTimeZone("BST"));
		int bstHour = cal.getTime().getHours();
		int bstMin = cal.getTime().getMinutes();
		cal.setTimeZone(TimeZone.getTimeZone("CST"));
		int cstHour = cal.getTime().getHours();
		int cstMin = cal.getTime().getMinutes();
		
		String res = String.format("Time on Server: %d:%d\nGMT: %d:%d\nBST: (90E): %d:%d\nCST(90W): %d:%d", curHour,curMin,gmtHour,gmtMin,bstHour,bstMin,cstHour,cstMin);
		System.out.println(res);
	}
	@SuppressWarnings("deprecation")
	void dateTimeDifferentZone() {
		HashMap<String, ZonedDateTime> timeZones = new HashMap<String, ZonedDateTime>();
		curTime = LocalDateTime.now();
		timeZones.put("GMT", curTime.atZone(ZoneId.of("GMT")));
		timeZones.put("BST", curTime.atZone(ZoneId.of("BST")));
		timeZones.put("CST", curTime.atZone(ZoneId.of("CST")));
		timeZones.put("ZST", new Date(2019,11,5,19,59));
		timeZones.put("AST", new Date(2020,10,1,19,59));

		
	}
	void timeZoneHashMap() {
		
	}
}