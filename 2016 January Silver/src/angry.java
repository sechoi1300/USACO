import java.util.*;
import java.io.*;

public class angry {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k;
	static int[] x;
	static int min, max, mid, ans;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("angry.in"));
		st = new StringTokenizer(in.readLine());
		out = new PrintWriter(new File("angry.out"));
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		solve();
	}
	
	public static void solve() {
		min = 0;
		max = 1000000000;
		while(min <= max) {
			mid = (min + max) / 2;
			if(check(mid)) {
				max = mid - 1;
				ans = mid;
			} else {
				min = mid + 1;
			}
		}
		out.println(ans);
		out.close();
	}
	
	public static boolean check(int mid) {
		int temp = mid * 2 + x[0];
		int count = 1;
		for(int i = 1; i < n; i++) {
			if(x[i] <= temp) continue;
			else {
				count++;
				temp = mid * 2 + x[i];
			}
		}
		return count <= k;
	}

}
