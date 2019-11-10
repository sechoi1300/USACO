import java.util.*;
import java.io.*;

public class blocks {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static int[] first, second, total;
	static String f, s;
	
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
        total = new int[26];
	}

	public static void solve() {
		for(int j = 0; j < N; j++) {
			f = in.next();
	        s = in.next();
	        first = new int[26];
	        second = new int[26];
			for(int i = 0; i < f.length(); i++) {
				int temp = f.charAt(i) - 'a';
				first[temp]++;
			}
		    for(int i = 0; i < s.length(); i++) {
	            int temp = s.charAt(i) - 'a';
				second[temp]++;
			}
		    for(int i = 0; i < 26; i++) {
	            int max = Math.max(first[i], second[i]); 
				total[i]+=max;
			}
		}
		for(int i = 0; i < 26; i++) {
			out.println(total[i]);
        }
	}
}
