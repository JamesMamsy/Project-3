import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.time.*;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	LocalDateTime curTime;
	HashMap<String, String> timeZones;
	TreeMap<String, String> sortedTimeZones;
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
	void dateTimeDifferentZone() {
		String pattern = "MM/dd/yyyy HH:mm";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		
		timeZones = new HashMap<String, String>();
		curTime = LocalDateTime.now();
		timeZones.put("GMT", formatter.format(curTime.atZone(ZoneId.of("GMT")).toLocalDateTime()));
		timeZones.put("BST", formatter.format(curTime.atZone(ZoneId.of("BST")).toLocalDateTime()));
		timeZones.put("CST", formatter.format(curTime.atZone(ZoneId.of("CST")).toLocalDateTime()));
		timeZones.put("ZST", formatter.format(LocalDateTime.of(2018, 11, 5, 19, 59)));
		timeZones.put("AST", formatter.format(LocalDateTime.of(2020,10,1,19,59)));
		
		timeZones.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
			
	}
	void timeZoneHashMap() {
		sortedTimeZones.putAll(timeZones);
		
		
		
		
		
	}
}