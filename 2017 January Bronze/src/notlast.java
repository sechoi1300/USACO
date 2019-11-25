import java.util.*;
import java.io.*;

public class notlast {
	
	static Scanner in;
	static PrintWriter out;
	static int N, min;
	static Map<String, Integer> a = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("notlast.in"));
		out = new PrintWriter(new File("notlast.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		for(int i = 0; i < N; i++) {
			String cowtemp = in.next();
			int milktemp = in.nextInt();
			a.put(cowtemp, milktemp);
		}
		min = 100;
	}
	
	public static void solve() {
		for(String name:a.keySet()) {
			min = Math.min(min, a.get(name));
		}
		//a.get(min) = 100;
		for(String name:a.keySet()) {
			min = Math.min(min, a.get(name));
		}
		//out.println();
	}
	
}