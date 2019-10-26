import static org.junit.jupiter.api.Assertions.*;

import java.util.TimeZone;

import org.junit.jupiter.api.Test;

class DateTimeOneTest {

	
	@Test
	void testTimeZoneHashMap() {
		DateTimeOne dt = new DateTimeOne();
		
		dt.dateTimeNow();
		dt.dateTimeDifferentZone();
	}

	@Test
	void sortedTimeZoneTest() {
		DateTimeOne dt = new DateTimeOne();
		
		dt.timeZoneHashMap();
	}

}
