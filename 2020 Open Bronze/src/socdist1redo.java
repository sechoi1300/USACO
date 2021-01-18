import java.util.*;
import java.io.*;

public class socdist1redo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, low, high, mid, ans;
	static String str;
	static ArrayList<Integer> index;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("socdist1.in"));
		out = new PrintWriter(new File("socdist1.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		str = st.nextToken();
		low = 1;
		high = n - 1;
		index = new ArrayList<Integer>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') index.add(i);
		}
		for(int i = 0; i < index.size() - 1; i++) {
			high  = Math.min(index.get(i + 1) - index.get(i), high);
		}
	}
	
	public static void solve() {
		if(index.size() == 0) {
			out.println(n - 1);
			return;
		}
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		out.println(ans);
	}
	
	public static boolean check(int num) {
		int cows = 0;
		int distance = num;
		for(int i = 0; i < index.size() - 1; i++) {
			for(int j = index.get(i); j < index.get(i + 1); j+=distance) {
				cows++;
			}
		}
		if(cows >= 2) return true;
		else return false;
	}

}
