import java.util.*;
import java.io.*;

public class lineup {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static Map<String, Integer> cowsToNum = new HashMap<String, Integer>();
	static Map<Integer, String> numToCows = new HashMap<Integer, String>();
	static String[] changesString;
	static String[] c;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("lineup.in"));
		out = new PrintWriter(new File("lineup.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		cowsToNum.put("Beatrice", 0);
		cowsToNum.put("Belinda", 1);
		cowsToNum.put("Bella", 2);
		cowsToNum.put("Bessie", 3);
		cowsToNum.put("Betsy", 4);
		cowsToNum.put("Blue", 5);
		cowsToNum.put("Buttercup", 6);
		cowsToNum.put("Sue", 7);
		numToCows.put(0, "Beatrice");
		numToCows.put(1, "Belinda");
		numToCows.put(2, "Bella");
		numToCows.put(3, "Bessie");
		numToCows.put(4, "Betsy");
		numToCows.put(5, "Blue");
		numToCows.put(6, "Buttercup");
		numToCows.put(7, "Sue");
		N = in.nextInt(); in.nextLine();
		System.out.println(N);
		
		c = new String[N];
		for(int i = 0; i < N; i++) {
			changesString = in.nextLine().split(" "); //System.out.println(Arrays.toString(changesString));
			c[i] =""+ cowsToNum.get(changesString[0]) + cowsToNum.get(changesString[5]);
			c[i]+=""+ cowsToNum.get(changesString[5]) + cowsToNum.get(changesString[0]);
		}
		
			
		System.out.println(Arrays.toString(c));
		/*changesInt = new int[N * 2];
		changesInt1 = new int[N * 2];
		changesInt2 = new int[N * 2];
		for(int i = 0; i < N * 2; i++) {
			changesInt[i] = cowsToNum.get(changesString[i]);
		}
		for(int i = 0; i < N * 2; i+=2) {
			String temp = Integer.toString(changesInt[i]) + Integer.toString(changesInt[i + 1]);
			changesInt1[i] = Integer.parseInt(temp);
			temp = Integer.toString(changesInt[i + 1]) + Integer.toString(changesInt[i]);
			changesInt2[i] = Integer.parseInt(temp);
		}*/
	}
	
	public static void solve() {
	
	}

}
/*
private static void permute(String string, String result) {
	    	if(string.length() == 0) {
	    		arrList.add(result);
	    		return;
	    	}
	    	for(int i = 0; i < string.length(); i++) {
	    		char c = string.charAt(i);
	    		String s = string.substring(0, i) + string.substring(i + 1);
	    		permute(s, result + c);
	    	}
	    }

*/