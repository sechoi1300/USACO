import java.util.*;
import java.io.*;

public class notlast {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static ArrayList<String> cows;
	static ArrayList<Integer> milk;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("notlast.in"));
		out = new PrintWriter(new File("notlast.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		cows = new ArrayList<String>();
		milk = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < cows.size(); j)
		}
	}
	
	public static void solve() {
		
	}
	
}
