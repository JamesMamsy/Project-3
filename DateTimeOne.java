import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.time.*;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	LocalDateTime curTime;
	HashMap<String, LocalDateTime> timeZones;
	TreeMap<String, String> sortedTimeZones;
	TreeMap<String,String> sortedFormatted;
	
	
	public DateTimeOne(){
		initHashMaps();		
	}
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
		timeZones.entrySet().forEach(
				entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 }
				);
			
		System.out.println("\nEnd Of Input\n");
	}
	void timeZoneHashMap() {
		
		System.out.println("Format 1:");
		sortedTimeZones.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
		
		System.out.println("Format 2:");
		//forEachFunction would not work, using forEach loop instead
		for(Map.Entry<String, String> entry:sortedFormatted.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
	
	void initHashMaps() {
		//Set-Up UnSorted HashMap
		String pattern = "MM/dd/yyyy HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		
		timeZones = new HashMap<String, LocalDateTime>();
		curTime = LocalDateTime.now();
		timeZones.put("GMT", curTime.atZone(ZoneId.of("GMT")).toLocalDateTime());
		timeZones.put("BST", curTime.atZone(ZoneId.of("GMT+6")).toLocalDateTime());
		timeZones.put("CST", curTime.atZone(ZoneId.of("GMT-5")).toLocalDateTime());
		timeZones.put("ZST", LocalDateTime.of(2018,Month.NOVEMBER,5,19,59));
		timeZones.put("AST", LocalDateTime.of(2020,Month.OCTOBER,1,19,59));
		
		//Setup Sorted Hashmap
		sortedTimeZones = new TreeMap<String, String>();
		timeZones.keySet().forEach(key->{
			sortedTimeZones.put(key, formatter.format(timeZones.get(key)));
			
		});
		//Formatters for 
		String datePattern = "MM/dd/yy";
		String timePattern = "HH:mm";
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
		
		//Setup Second Sorted Hashmap (for Second Format)
		sortedFormatted = new TreeMap<String, String>();
		timeZones.keySet().forEach(key->{
			sortedFormatted.put(dateFormatter.format(timeZones.get(key)), timeFormatter.format(timeZones.get(key)));
		});
	}
}