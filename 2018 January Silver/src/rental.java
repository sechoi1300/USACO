import java.util.*;
import java.io.*;

public class rental {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, r;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("rental.in"));
		out = new PrintWriter(new File("rental.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
	}
	
	public static void solve() {
		
	}

}
