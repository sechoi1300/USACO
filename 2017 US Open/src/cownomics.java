import java.util.*;
import java.io.*;

public class cownomics {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static char[][] sick, healthy;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("cownomics.in"));
		out = new PrintWriter(new File("cownomics.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		sick = new char[n][m];
		healthy = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String temp = st.nextToken();
			for(int j = 0; j < m; j++) {
				sick[i][j] = temp.charAt(j);
			}
		}
		for(int i = n; i < n + n; i++) {
			st = new StringTokenizer(in.readLine());
			String temp = st.nextToken();
			for(int j = 0; j < m; j++) {
				healthy[i - n][j] = temp.charAt(j);
			}
		}
		/*
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(healthy[i]));
		}
		*/
	}
	
	public static void solve() {
		int count = 0;
		boolean flag = false;
		for(int i = 0; i < m; i++) {
			if(healthyAllSame(i)) {
				char temp = healthy[0][i];
				//System.out.println(temp);
				for(int j = 0; j < n; j++) {
					if(sick[j][i] == healthy[0][i]) {
						//System.out.println(sick[j][i] + " " + healthy[0][i]);
						flag = true;
						break;
					}
				}
				if(!flag) count++;
				flag = false;
			}
		}
		out.println(count);
	}
	
	public static boolean healthyAllSame(int m) {
		for(int i = 0; i < n - 1; i++) {
			if(healthy[i][m] != healthy[i + 1][m]) return false;
		}
		return true;
	}

}
