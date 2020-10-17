import java.util.*;
import java.io.*;

public class hps {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n;
	static char[] c;
	static int[][] prefix, suffix;
	static int pnum, hnum, snum;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("hps.in"));
		out = new PrintWriter(new File("hps.out"));

		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		c = new char[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			c[i] = st.nextToken().charAt(0); 
		}
		prefix = new int[n][3];
		suffix = new int[n + 1][3];
		pnum = 0;
		hnum = 0;
		snum = 0;
		//System.out.println(n);
		//System.out.println(Arrays.toString(c));
	}
	
	public static void solve() {
		for(int i = 0; i < n; i++) {
			if(c[i] == 'P') pnum++;
			else if(c[i] == 'H') hnum++;
			else snum++;
			prefix[i][0] = pnum;
			prefix[i][1] = hnum;
			prefix[i][2] = snum;
		}
		pnum = 0;
		hnum = 0;
		snum = 0;
		int index = 0;
		/*
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(prefix[i]));
		}
		*/
		for(int i = n - 1; i >= 0; i--) {
			if(c[i] == 'P') pnum++;
			else if(c[i] == 'H') hnum++;
			else snum++;
			suffix[i][0] = pnum;
			suffix[i][1] = hnum;
			suffix[i][2] = snum;
			index++;
		}
		/*
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(suffix[i]));
		}
		*/
		int result = -100000000;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					result = Math.max(prefix[i][j] + suffix[i + 1][k], result);
				}
			}
		}
		out.println(result);
	}

}
