import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;

public class DateSortingUsingAlgorithm {
	BufferedReader br;
	HashMap<LocalDate, Integer> datesMap;
	DateTimeFormatter formatter;
	public DateSortingUsingAlgorithm() {
		try {
		buildStationData();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void dateHashMapSortedDescending() {
		//Convert To Array
		LocalDate[] unsortedArray = new LocalDate[datesMap.size()];
		datesMap.keySet().toArray(unsortedArray);
		LocalDate[] sortedArray = bubbleSortDesc(unsortedArray);
		
		for(int x = 0; x < sortedArray.length; ++x) {
			System.out.println(sortedArray[x]);
		}
		//
	}
	
	
	public LocalDate[] bubbleSortAcend(LocalDate[] arry) {
		LocalDate temp;
		//Iterate through each comparison unit
		for (int i = 0; i < arry.length - 1; i++) {
			//Iterate through array for other unit
			for (int j = 1; j < arry.length - i; j++) {
				//If the previous unit is less, than move [j-1] above [j]
				if (arry[j - 1].compareTo(arry[j]) > 0){
					temp = arry[j - 1];
					arry[j - 1] = arry[j];
					arry[j] = temp;
				}
			}
		}
		return arry;
	}
	
	public LocalDate[] bubbleSortDesc(LocalDate[] arry) {
		LocalDate temp;
		for (int i = 0; i < arry.length - 1; i++) {
 
			for (int j = 1; j < arry.length - i; j++) {
				if (arry[j - 1].compareTo(arry[j]) < 0) {
					temp = arry[j - 1];
					arry[j - 1] = arry[j];
					arry[j] = temp;
				}
			}
		}
		return arry;
	}
	
	public void dateHashMapSorted() {
		LocalDate[] unsortedArray = new LocalDate[datesMap.size()];
		datesMap.keySet().toArray(unsortedArray);
		LocalDate[] sortedArray = bubbleSortAcend(unsortedArray);
		
		for(int x = 0; x < sortedArray.length; ++x) {
			System.out.println(sortedArray[x]);
		}
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
