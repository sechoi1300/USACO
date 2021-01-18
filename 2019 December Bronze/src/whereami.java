import java.util.*;
import java.io.*;

public class whereami {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n;
	static String str;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("whereami.in"));
		out = new PrintWriter(new File("whereami.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		str = st.nextToken();
		System.out.println();
	}
	
	public static void solve() {
		int ans = 0;
		for(int i = 1; i < n; i++) {
			String temp = str.substring(0, i);
			if(str.substring(i).contains(temp)) {
				continue;
			} else {
				ans = i;
				break;
			}
		}
		out.println(ans);
	}

}
