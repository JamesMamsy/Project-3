import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	HashMap<String, Integer> unsortedMap;
	public MesoLexicographical(HashMap<String, Integer> unsortedMap) {
		this.unsortedMap = unsortedMap;
		Map<String, Integer> newMap = sortedMap(unsortedMap);
		
		System.out.println("Output: Sorted:");
		for(Map.Entry<String, Integer> entry: newMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted){
		Map<String, Integer> res = new TreeMap<String, Integer>();
		
		res.putAll(unsorted);
		
		return res;
	};

}