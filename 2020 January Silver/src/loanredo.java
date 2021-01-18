import java.util.*;
import java.io.*;

public class loanredo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static long n, k, m;
	static long low, high, mid, ans;

	public static void main(String[] args) throws IOException{
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
	
	public static boolean check(long x) {
		long remains = n;
		long days = k;
		while(remains > 0 && days > 0) {
			long y = remains / x;
			if(y <= m) return m * days >= remains;
			long pass = 1 + (remains - x * y) / y;
			remains -= y * pass;
			days -= pass;
		}
		return remains <= 0;
	}

}
