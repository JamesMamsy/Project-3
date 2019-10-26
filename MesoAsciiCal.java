
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	Double avg;
	MesoStation mesoStation;

	public MesoAsciiCal(MesoStation mesoStation) {
		this.mesoStation = mesoStation;
	}
	
	@Override
	int calAverage() {
		String name = mesoStation.getStID();
		Double avg = 0.0;
		int ceilValue;
		int floorValue;
		int firstAvg;
		int secondAvg;
		
		for(int x = 0; x < name.length(); ++x) {
			avg += (int)name.charAt(x);
		}
		
		avg = (double)avg/name.length();
		ceilValue = (int)Math.ceil(avg);
		floorValue = (int)Math.floor(avg);
		
		
		if(avg - (double)floorValue >= 0.75) {
			 firstAvg = ceilValue;
		}
		else {
			firstAvg =floorValue;
		}
		
		secondAvg = 79;
		
		return (int)Math.ceil((double)(firstAvg+secondAvg) / 2);
		
	}


	
   
}