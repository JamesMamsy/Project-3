import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class DateSortingUsingAlgorithm {
	BufferedReader br;
	HashMap<LocalDate, Integer> datesMap;
	DateTimeFormatter formatter;
	public DateSortingUsingAlgorithm() {
		
	}
	
	public void dateHashMapSortedDescending() {
	}
	
	public void dateHashMapSorted() {
		
	}
	
	private void buildStationData() throws IOException {
		br = new BufferedReader(new FileReader("SortingDates.txt"));
		datesMap = new HashMap<LocalDate, Integer>();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		// Get first (the station name)
		String tempLine = br.readLine().trim().replaceAll("\\s+", " ") ;

		// Place into array
		int x = 0;
		while (tempLine != null) {

			String[] sl = tempLine.split(" ");

			String date = sl[0];
			// Add station name to station object's list
			datesMap.put(LocalDate.parse(date, formatter), x);
			++x;
			//Catch end of file
			try {
				tempLine = br.readLine().trim().replaceAll("\\s+", " ");
			} catch (NullPointerException e) {
				break;
			}

		}
		br.close();
	}

}
