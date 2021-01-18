import java.util.*;
import java.io.*;

public class cowntagion {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static int[] a;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader (new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		a = new int[n - 1];
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void solve() {
		
	}

}
