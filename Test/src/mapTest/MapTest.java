package mapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		for(int i=0; i<10; i++){
			map.put(i+"key", i+"value");
		}
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = map.keySet().iterator();
		while (keyIterator.hasNext()) {
			System.out.println(keyIterator.next());
		}
		
		for(int i=0; i<keySet.size(); i++){
			
		}
		
		for(String key : map.keySet()){
			
		}
		
		for(Entry<String, String> entry: map.entrySet()){
			
		}
	}

}
