import java.util.*;

public class MapPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> a = new HashMap<String, Integer>();
		a.put("Julia", 100);
		a.put("Solomon", 90);
		a.put("Eric", 95);
		
		for(String name:a.keySet()) {
			a.put(name, a.get(name) + 10);
		}
		
		for(String name:a.keySet()) {
			System.out.println(name + " " + a.get(name));
		}
	}

}
