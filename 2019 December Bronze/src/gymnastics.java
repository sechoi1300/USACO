import java.util.*;
import java.io.*;

public class gymnastics {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int[][] scores;
	static int n, k;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("gymnastics.in"));
		out = new PrintWriter(new File("gymnastics.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		scores = new int[k][n];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		for(int i = 0; i < k; i++) {
			System.out.println(Arrays.toString(scores[i]));
		}
		*/
	}
	
	public static void solve() {
		boolean[] b = new boolean[n];
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				for(int l = 0; l < k; l++) {
					System.out.println(scores[l][i] + " " + scores[l][j]);
					if(scores[l][i] > scores[l][j]) {
						b[j] = true;
					}
				}
				if(check(b)) count++;
				b = new boolean[n];
			}
			System.out.println();
		}
		System.out.println(count);
	}
	
	public static boolean check(boolean[] b) {
		int count = 0;
		System.out.println(Arrays.toString(b));
		for(int i = 0; i < b.length; i++) {
			if(b[i]) count++;
		}
		return count <= 1;
	}

}
