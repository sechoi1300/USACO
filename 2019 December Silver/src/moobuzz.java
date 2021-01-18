import java.util.*;
import java.io.*;

public class moobuzz {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, ans;
	static int[] key;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("moobuzz.in"));
		out = new PrintWriter(new File("moobuzz.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		key = new int[] {1, 2, 4, 7, 8, 11, 13, 14};
	}
	
	public static void solve() {
		ans = n / 8 * 15;
		if(n % 8 == 0) ans++;
		else ans+=key[(n % 8) - 1];
		out.println(ans);
	}

}
