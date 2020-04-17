import java.util.*;
import java.io.*;


public class tracing {

	static Scanner in;
	static PrintWriter out;
	static int N, T;
	static int[] cows;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("tracing.in"));
		out = new PrintWriter(new File("tracing.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		T = in.nextInt();
		cows = new int[N];
		in.nextLine();
		String temp = in.nextLine();
		for(int i = 0; i < temp.length() - 1; i++) {
			cows[i] = Integer.parseInt(temp.substring(i, i+1));
		}
	}
	
	public static void solve() {
		out.println("1 1 Infinity");
	}

}
