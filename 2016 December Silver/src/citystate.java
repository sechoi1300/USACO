import java.util.*;
import java.io.*;

public class citystate {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static HashMap<String, Integer> a;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("citystate.in"));
		out = new PrintWriter(new File("citystate.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		a = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String str1 = st.nextToken();
			str1 = str1.substring(0, 2).toUpperCase();
			String str2 = st.nextToken().toUpperCase();
			//String key = str1 + str2;
			if(a.containsKey(str1 + str2)) a.put(str1 + str2, a.get(str1 + str2) + 1);
			else a.put(str1 + str2, 1);
		}
		//System.out.println(a);
	}
	
	public static void solve() {
		String temp = "";
		long result = 0;
		for(String s1:a.keySet()) {
			temp = "";
			temp = s1.substring(2, 4) + s1.substring(0, 2);
			if(temp.equals(s1)) {
				continue;
			}
			if(a.containsKey(temp)) {
				result+=a.get(temp) * a.get(s1);
			}
		}
		//System.out.println(result);
		out.println(result / 2);
	}

}
