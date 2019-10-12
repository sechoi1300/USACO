import java.util.*;
import java.io.*;

public class speeding {
	
	static Scanner in;
	static PrintWriter out;
	static int N, M, n[], m[], tempN, tempM, max;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("speeding.in"));
		out = new PrintWriter(new File("speeding.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		M = in.nextInt();
		n = new int[100];
		m = new int[100];
		tempN = 0;
		tempM = 0;
		for(int i = 0; i < N; i++) {
			int templength = in.nextInt();
			int tempspeed = in.nextInt();
			for(int j = tempN; j < templength + tempN; j++) {
				n[j] = tempspeed;
			}
			tempN += templength;
		}
		for(int i = 0; i < M; i++) {
			int templength = in.nextInt();
			int tempspeed = in.nextInt();
			for(int j = tempM; j < templength + tempM; j++) {
				m[j] = tempspeed;
			}
			tempM += templength;
		}
		max = 0;
	}
	
	public static void solve() {
		for(int i = 0; i < 100; i++) {
			if(m[i] > n[i]) {
				max = Math.max(max,  m[i] - n[i]);
			}
		}
		out.println(max);
	}
	
}
