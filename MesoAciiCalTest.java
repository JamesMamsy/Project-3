import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class MesoAciiCalTest {

	@Test
	void test() {
		MesoAsciiCal cal = new MesoAsciiCal(new MesoStation("OKCE"));
		System.out.println(cal.calAverage());
	}
	
	@Test
	void sortedTest(){
		MesoEquivalent mesoEqual = new MesoEquivalent("OKCE");
		
		HashMap<String, Integer> asciiVal = mesoEqual.calAsciiEqual();		
		for (String stIds : asciiVal.keySet()) 
		{
			//System.out.println(stIds + " " + asciiVal.get(stIds));
			//Printing the unsorted map
		    System.out.println(stIds + " " + asciiVal.get(stIds));		    
		}	
		System.out.println("Sorted::  ");
		MesoLexicographical mesoLexi = new MesoLexicographical(asciiVal);
		
	}

}
