import java.util.*;
import java.io.*;

public class sleepy {

	static Scanner in;
	static PrintWriter out;
	static int N, cows[], moves;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("sleepy.in"));
		out = new PrintWriter(new File("sleepy.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		cows = new int[N];
		for(int i = 0; i < N; i++) {
			cows[i] = in.nextInt();
		}
	}
	
	public static void solve() {
		moves = 0;
		for(int i = N - 1; i > 0; i--) {
			if(cows[i - 1] > cows[i]) {
				moves = i;
				break;
			}
		}
		out.println(moves);
	}
	
}
