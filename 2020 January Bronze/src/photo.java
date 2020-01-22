import java.util.*;
import java.io.*;

public class photo {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static int[] num;
	static ArrayList<Integer> result;
	static boolean containsZero, duplicates;
	static TreeMap<Integer, Integer> m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("photo.in"));
		out = new PrintWriter(new File("photo.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		result = new ArrayList<Integer>();
        num = new int[N - 1];
        for(int i = 0; i < N - 1; i++)
          num[i] = in.nextInt();
      
        m = new TreeMap<Integer, Integer>();
      
        for(int i = 1; i < num[0]; i++){
          if(i != num[0] - i)
             m.put(i, num[0] - i);
        }
		containsZero = false;
		duplicates = false;
	}
	
	public static void solve() {
		for(int a: m.keySet()) {
			int b = m.get(a);
	          
			result.add(a);
			result.add(b);
	        for(int i = 1; i < num.length; i++){
	        	
	        	int t = num[i] - result.get(result.size() - 1);  
	        	if(t > 0 && t <= N && !result.contains(t)) result.add(t);
	            else {
	            	result = new ArrayList<Integer>();
	            	break;
	            }

	    		
	        }
	        
	        if(result.size()==N) break;      
	          
	    }
		String str = result.get(0) + "";
		for(int i = 1; i < result.size(); i++) {
			str += " " + result.get(i);
		}
		out.println(str);
	}

}
