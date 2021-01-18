import java.util.*;
import java.io.*;

public class pails {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int x, y, m, ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("pails.in"));
		out = new PrintWriter(new File("pails.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	}
	
	public static void solve() {	
		for(int i = 0; i * x <= m ; i++) {
			for(int j = 0; j * y <= m; j++) {
				if(i * x + j * y > ans && i * x + j * y <= m) {
					ans = i * x + j * y;
				}
			}
		}
		out.println(ans);
	}

}
