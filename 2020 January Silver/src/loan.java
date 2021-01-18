import java.util.*;
import java.io.*;

public class loan {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static long n, k, m;
	static long ans, low, high, mid;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("loan.in"));
		out = new PrintWriter(new File("loan.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
	}
	
	public static void solve() {
		low = 1;
		high = n;
		ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				low = mid + 1;
				ans = mid;
			} else {
				high = mid - 1;
			}
		}
		out.println(ans);
	}
	
	public static boolean check(long x) {
		long left = n;
		long days = k;
		while(left > 0 && days > 0) {
			long y = left / x;
			if(y <= m) return m * days >= left;
			long pass = 1 + (left - x * y) / y;
			left -= y * pass;
			days-=pass;
		}
		return left <= 0;
	}

}
