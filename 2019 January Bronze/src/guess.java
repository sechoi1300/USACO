import java.util.*;
import java.io.*;

public class guess {
	
	static Scanner in;
	static PrintWriter out;
	static int N, max;
	static ArrayList<String> [] a;
	static ArrayList<Integer> last = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("guess.in"));
		out = new PrintWriter(new File("guess.out"));
		
		init();
		solve();
	}
	
	public static void init() {
		N = in.nextInt();
		a = new ArrayList[N];
		max = 0;
		for(int i = 0; i < N; i++) {
			a[i] = new ArrayList<String>();
			in.next();
			int k = in.nextInt();
			for(int j = 0; j < k; j++) {
				a[i].add(in.next());
			}
		}
	}
	
	public static void solve() {
		int same = 0;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				for(String p : a[i]) {
					if(a[j].contains(p)) {
						same++;
					}
				}
				max = Math.max(max, same);
				same = 0;
			}
			
		}
		out.println(max + 1);
		out.close();
	}
}
