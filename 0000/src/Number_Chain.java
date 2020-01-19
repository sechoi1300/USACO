import java.util.*;
import java.io.*;

public class Number_Chain {

	static Scanner in;
	static PrintWriter out;
	static int n, num;
	static int[] result;
	static boolean containsZero;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("Number_Chain.in"));
		out = new PrintWriter(new File("Number_Chain.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		n = in.nextInt();
		result = new int[n];
		containsZero = false;
	}
	
	public static void solve() {
		while(true) {
			result[0]++;
			result[1] = n - result[0];
			for(int i = 2; i < n - 1; i++) {
				num = in.nextInt();
				result[i] = num - result[i - 1];
			}
			for(int i = 0; i < result.length; i++) {
				if(result[i] == 0) containsZero = true;
			}
			if(!containsZero) break;
		}
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
}
