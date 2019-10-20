import java.util.*;
import java.io.*;

public class blocks {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static String[] words;
	static ArrayList<Character> a = new ArrayList<Character>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("blocks.in"));
		out = new PrintWriter(new File("blocks.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		words = new String[N * 2];
		for(int i = 0; i < N * 2; i ++) {
			words[i] = in.next();
		}
		for(int i = 0; i < N * 2; i++) {
			char[] temp = words[i].toCharArray();
			for(int j = 0; j < temp.length; j++) {
				a.add(temp[j]);
			}
		}
	}

	public static void solve() {
		
	}
	
}
