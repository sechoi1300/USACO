import java.util.*;
import java.io.*;

public class measurement {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, g, ans;
	static cow[] input;
	static HashMap<Integer, Integer> cowMap;
	static TreeMap<Integer, Integer> milkMap;
	static int maxMilk, maxCow, boardMilk, boardCow;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("measurement.in"));
		out = new PrintWriter(new File("measurement.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		input = new cow[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int day = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken());
			int change = Integer.parseInt(st.nextToken());
			input[i] = new cow(day, id, change);
		}
		Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		cowMap = new HashMap<Integer, Integer>();
		milkMap = new TreeMap<Integer, Integer>();
		maxMilk = g;
		maxCow = 100000000;
		milkMap.put(maxMilk, maxCow);
	}
	
	public static void solve() {
		for(int i = 0; i < n; i++) {
			int currentid = input[i].id;
			int currentmilk = 0;
			if(cowMap.containsKey(currentid)) currentmilk = cowMap.get(currentid);
			else currentmilk = g;
			int currentchange = input[i].change;
			if(boardMilk == currentmilk) {
				boardMilk+=currentchange;
			}
			if(milkMap.get(currentmilk) == 1) {
				milkMap.remove(currentmilk);
			} else {
				milkMap.put(currentmilk, milkMap.get(currentmilk) - 1);
			}
			currentmilk+=currentchange;
			if(milkMap.containsKey(currentmilk)) {
				milkMap.put(currentmilk, milkMap.get(currentmilk) + 1);
			} else {
				milkMap.put(currentmilk, 1);
			}
			cowMap.put(currentid, currentmilk);
			maxMilk = milkMap.lastKey();
			maxCow = milkMap.get(maxMilk);
			if(maxMilk != boardMilk || maxCow != boardCow) {
				ans++;
				boardMilk = maxMilk;
				boardCow = maxCow;
			}
		}
		out.println(ans);
		//System.out.println(ans);
	}

}

class cow implements Comparable<cow> {
	int day;
	int id;
	int change;
	cow(int d, int i, int c) {
		day = d;
		id = i;
		change = c;
	}
	public String toString() {
		return day + " " + id + " " + change;
	}
	@Override
	public int compareTo(cow that) {
		if(this.day == that.day) return this.id - that.id;
		else return this.day - that.day;
	}
}