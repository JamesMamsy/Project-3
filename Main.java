/**
 * @author Mohammad Mukhtaruzzaman
 * @version 2019-10-08
*/
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		/**
		 * This project has been divided in sections. 
		 * Keep in mind, the code given here all are related. Section has been created to give you 
		 * a break from a continuous long discussion.
		 * When we want any output from a method, we have given the intended output 
		 * immediately above the line of code.
		 * Looking at the sample text output will give you a better idea about output. 
		 */
		int sectionCount = 0;		
		int allowedValueForSecond = 55;
		DateTimeOne dateTimeOne = new DateTimeOne();
		/**
		 * Since in this project we will work with date and time, therefore, at first we want to ensure
		 * that you will not get caught by Zylab with a wrong result, if you submit at the end of any 
		 * minute. To ensure this, you have to measure the "Second" value of the current time.
		 * If 'Second' is greater than 55, you have to sleep your program for 5 seconds. 
		 */				
		
		/**
		 * Section 1
		 * Current value of “Second” will be stored in vlaueOfSecondNow 
		 * and will print as, "The value of Second now: 58"
		 * Remember, this is the format only, value should be the current time.
		 */
		int vlaueOfSecondNow = dateTimeOne.getValueOfSecond();
		/**
		 * If vlaueOfSecondNow>55, program will sleep for 5 seconds.
		 */		
		
		if(vlaueOfSecondNow > allowedValueForSecond)
		{
			dateTimeOne.sleepForFiveSec();
		}
		
		/**
		 * Print the present date/time as:"Current Date/Time: 10/08/2019 03:03 PM"
		 * You have to identify the format from this given output and will code accordingly.
		 * Here is a clue, month/day/year hour:minute am/pm 
		 */
		
	    dateTimeOne.dateTimeNow();	    
	    //System.out.println("Time in the major Time Zone: ");	    
	    
	    System.out.println("\nTime at other zones:");
	    /**
		 * We have got time for our server but we have some major time zone in the world.
		 * GMT is considered as zero degree (Greenwich Mean Time) which is GMT + 0 = GMT
		 * BST is 90 degree East (Bangladesh Standard Time) which is 6 hours ahead of GMT, and
		 * CST is 90 degree West (Central Standard Time) which is 5 hours behind of GMT during 
		 * daylight saving. Otherwise, it is 6 hours.
		 * We are not considering 0 or 180 degree.
		 * 
		 * Now, we will print the time for these four in a different way. Again, time should be
		 * the current time; in your case, time of the server. Determine the format from the output given.
		 * The output is here (pls look at the text sample, if needed).
			Time on Server: 15:14
			GMT: 20:14
			BST (90E): 2:14
			CST (90W): 15:14
		 */
	    dateTimeOne.dateTimeOfOtherCity();
	    System.out.println("\nDate/time at other zones:");
	    //dateTimeOne.dateTimeNow();
	    
	    /**
		 * Now, you are familiar with different time zone.		 * 
		 * Generate the following output. You should store the values in a Hashmap also. 
		 * GMT, BST etc. will as key and time/date as value.
		 * For this time, your Hashmap key and value should be String like HashMap<String, String> 
			GMT: 10/08/2019 20:26
			BST: 10/09/2019 02:26
			CST: 10/08/2019 15:26
		 */
	    dateTimeOne.dateTimeDifferentZone();
	    System.out.println("\n");	    
	    
	    /**
		 * Now add two more time zone like this: (These two may not be real time zone)
		 * "ZST", "11/05/2018 19:59" and "AST", "10/01/2020 19:59".
		 * For the details for these section See PDF section: Section 1 Extension, and come back here.
		 * 
		 * Output of the following method will be like (for grading you have to print only the following three style)
		 * exactly as below:
		 * 
			Print Style 1:
			AST 10/01/2020 19:59
			BST 10/09/2019 02:48
			CST 10/08/2019 15:48
			GMT 10/08/2019 20:48
			ZST 11/05/2018 19:59
			Print Style 3:
			10/01/2020 19:59
			10/08/2019 15:48
			10/08/2019 20:48
			10/09/2019 02:48
			11/05/2018 19:59
			Print Style 5: Final sorted Array:
			2020-10-01T19:59
			2019-10-09T02:48
			2019-10-08T20:48
			2019-10-08T15:48
			2018-11-05T19:59 
		 * 
		 * Look at the three style (1, 3, 5). They are giving you different types of sorted list that are confusing.
		 * We need to solve it; however, this section is complete, now we will move to the next section.
		 */
	    dateTimeOne.timeZoneHashMap();
	    
	    System.out.println("\n");
	    DateTimeTwo dateTimeTwo = new DateTimeTwo();
	    /**
		 * Section 2
		 * 
		 * From the next method, following output will be generated. Here, "THURSDAY" and "FRIDAY" are 
		 * generated from two variables "tenthDay" and "eighteenthtDay"; 
		 * Code is like: "The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthtDay
		 * Thus, you can get the DAY for any date of the current month.
		 * Output: (the next line)
		 * The tenth day of this month is THURSDAY and eighteenth is FRIDAY 
		 */
	    
	    dateTimeTwo.daysOfCurrentMonth();
	    System.out.println("\n");
	    
	    /**
	     * Now make your above method generalize for any month and year
	     * In the following, first parameter is month number and the second is year.
	     * Output format is:
			For the year (2019) and month (10), the fifteenth day is TUESDAY and the last day is THURSDAY
			For the year (2019) and month (11), the fifteenth day is FRIDAY and the last day is SATURDAY
			For the year (2020) and month (2), the fifteenth day is SATURDAY and the last day is SATURDAY
			For the year (2000) and month (2), the fifteenth day is TUESDAY and the last day is TUESDAY
		 */	    
	    dateTimeTwo.daysOfAnyMonth(10, 2019);
	    dateTimeTwo.daysOfAnyMonth(11, 2019);
	    dateTimeTwo.daysOfAnyMonth(2, 2020);
	    dateTimeTwo.daysOfAnyMonth(2, 2000);//many other values will be tested.
	    System.out.println("\n");
	    
	    /**
	     * 
	     * Read the text file: Dates.txt
	     * 
	     * The contents are like: 
			05.05.2017
			01.01.2004
	     * 
	     * First you will determine the year is a leap year or not. In the second part, calculate the difference 
	     * between today and the given date. Today means the server date during execution.
	     * At the same time, save these date in a Hashmap as HashMap<LocalDate, Integer>
	     * Keys are in the file, for map value use numeric values starting from 1. 
	     * Output format is:
			2017 is not a leap year, and Difference: 2 years, 5 months, and 3 days.
			2004 is a leap year, and Difference: 15 years, 9 months, and 7 days.
		 * 
		 */
	    dateTimeTwo.compareYear();
	    System.out.println("\n");	    
	    
	    /**
		 * Now print out your Hashmap. It may look like (This is the format, I didn't print whole map.
		 * Key:value
			2010-10-30:6
			2019-05-30:3
		 */
	    
	    dateTimeTwo.dateHashMap();
	    System.out.println("\nNow the Hashmap:");	    
	    
	    /**
		 * Sort your Hashmap ascending order using keys. 
		 * You can see the difference between Section 1 sorted list and the Section 2 sorted list.
		 * Write the difference in your documentation, and why?
		 * Print the sorted Hashmap. It will be like:
			1900-12-31:8
			2000-12-15:5
		 */
	    dateTimeTwo.dateHashMapSorted();
	    System.out.println("\nSorted map:");	    
	    
	    /**
		 * Section 3
		 * For details first see the PDF Section 3 Extension
		 * 
		 */
		String stId = "OKCE";
		MesoAsciiCal asciiAverage = new MesoAsciiCal(new MesoStation(stId));
		int asciiAvg = asciiAverage.calAverage();		

		HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
		asciiVal.put(stId, asciiAvg);
		System.out.print("ASCII average: ");
		//System.out.println(asciiAvg);
		
	    /**
	     * Calculate and print the ASCII average as per PDF. This value for NRMN as a sample.
		 * Output: 79
		 */
		System.out.println(asciiVal.get(stId));		
		
		MesoEquivalent mesoEqual = new MesoEquivalent(stId);		
	    /**
		 * Print the content of the hashmap
		 * Output: 
		 * {NRMN=79, OKMU=79, STIL=79, JAYX=79, NEWP=79, WOOD=79, STUA=79, WATO=79, MAYR=79, MRSH=79, WAUR=79}
		 */
		System.out.println("Stations are: "+ mesoEqual.calAsciiEqual());
		
		System.out.println("\nUnsroted Hashmap:");
		asciiVal=mesoEqual.calAsciiEqual();		
		for (String stIds : asciiVal.keySet()) 
		{
			//System.out.println(stIds + " " + asciiVal.get(stIds));
			//Printing the unsorted map
		    System.out.println(stIds + " " + asciiVal.get(stIds));		    
		}		
		
	    /**
		 * Sort your hashmap and print here
		 */
		//System.out.print("##");
		System.out.println("\nThe sorted map:");
		new MesoLexicographical(asciiVal);		
		
	    /**
		 * Section 4
		 *   
		 * For this section read the file, SortingDates.txt
		 * Parse the file and store in a hashmap. The dates as the key and as a date format, not string
		 * For example, HashMap<LocalDate, Integer>, but you can use any date function
		 * format of the date will be: 2020-12-31
		 * 
		 * For this section, you have to sort using an algorithm (such as Quick sort, Bubble sort etc.)
		 * Don't use any built-in function or other methods/map/list etc., you have to implement the algorithm
		 * You are free to choose any algorithm you prefer to implement such as Quick sort, Bubble
		 * sort, Radix sort, Insertion sort etc.
		 */
		System.out.println("\nFinally, the dates in HashMap are sorted using algorithm:\n");
	    DateSortingUsingAlgorithm dateSortingUsingAlgorithm = new DateSortingUsingAlgorithm();	    
	    
	    /**
		 * Sort the hashmap in descending order
		 * Output will be like:
		 * 2026-05-06
		 * 2021-03-31
		 * 2020-12-31
		 */
	    System.out.println("Sorting of the dates in descending order:");
	    long startTime = System.nanoTime();  
	    dateSortingUsingAlgorithm.dateHashMapSortedDescending();
	    long estimatedTime = System.nanoTime() - startTime;
	    
	    /**
		 * Sort the hashmap in ascending order.		 * 
		 * Output will be like:
		 * 2011-03-15
		 * 2012-10-10
		 * 2014-02-28
		 */
	    System.out.println("Sorting of the dates in ascending order:");
	    long startTime2 = System.nanoTime();  
	    dateSortingUsingAlgorithm.dateHashMapSorted();
	    long estimatedTime2 = System.nanoTime() - startTime2;
	    
	    System.out.println("\nExecution time for case 1: " + estimatedTime);
	    System.out.println("Execution time for case 2: " + estimatedTime2);
	    //You can see the difference in two execution times, why? explain in your documentation.
	}
}