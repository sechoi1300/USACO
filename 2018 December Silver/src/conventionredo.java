import java.util.*;
import java.io.*;

public class conventionredo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, c;
	static int[] cows;
	static int low, high, mid, ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("convention.in"));
		out = new PrintWriter(new File("convention.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		cows = new int[n];
		for(int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		//System.out.println(Arrays.toString(cows));
	}
	
	public static void solve() {
		low = 0;
		high = cows[cows.length - 1] - cows[0];
		ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		out.println(ans);
	}
	
	public static boolean check(int mid) {
		int count = 1;
		int capacity = 0;
		int temp = cows[0];
		for(int i = 0; i < n; i++) {
			if(cows[i] - temp <= mid) {
				capacity++;
			}
			if(capacity > c || cows[i] - temp > mid) {
				count++;
				temp = cows[i];
				capacity = 1;
			}
		}
		return count <= m;
	}

}
