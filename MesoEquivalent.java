import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent {
	String stID;
	BufferedReader br;
	ArrayList<String> stationList;
	final int _HEADERCNT = 2;

	
	public MesoEquivalent(String stID) {
		this.stID = stID;
		stationList = new ArrayList<String>();
		try {
		buildStationData();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, Integer> calAsciiEqual() {
		HashMap<String, Integer> asciiVals = new HashMap<String, Integer>();
		MesoAsciiCal avgCalc = new MesoAsciiCal(new MesoStation(this.stID));
		int compAvg = avgCalc.calAverage();
		
		for(int x = 0; x < stationList.size(); ++x) {
			int tempAvg = new MesoAsciiCal(new MesoStation(stationList.get(x))).calAverage();
			if(tempAvg == compAvg)
				asciiVals.put(stationList.get(x), tempAvg);
		}
		
		return asciiVals;
	}
	
	private void buildStationData() throws IOException {
		br = new BufferedReader(new FileReader("Mesonet.txt"));

		// Skip header lines
		int x = 0;
		while (x < _HEADERCNT) {
			br.readLine();
			++x;
		}

		// Get first (the station name)
		String tempLine = br.readLine().trim().replaceAll("\\s+", " ") ;

		// Place into array
		while (tempLine != null) {

			String[] sl = tempLine.split(" ");

			String name = sl[0];
			// Add station name to station object's list
			stationList.add(name);
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
