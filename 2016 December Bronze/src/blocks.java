import java.util.*;
import java.io.*;

public class blocks {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static String[] words;
	static ArrayList<Character> letters = new ArrayList<Character>();
	static int[] num = new int[26];
	
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
				letters.add(temp[j]);
			}
		}
		Collections.sort(letters);
		for(int i = 0; i < 26; i++) {
			
		}
	}

	public static void solve() {
		out.println(letters);
	}
	
}
