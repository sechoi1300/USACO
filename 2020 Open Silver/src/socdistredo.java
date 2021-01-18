import java.util.*;
import java.io.*;

public class socdistredo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m;
	static pair[] p;
	static long high, low, mid, ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("socdist.in"));
		out = new PrintWriter(new File("socdist.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new pair[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			p[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(p);
		high = 10000000;
		low = -1;
	}
	
	public static void solve() {
		while(low <= high) {
			mid = (high + low) / 2;
			if(check(mid)) {
				low = mid + 1;
				ans = (int) mid;
			} else {
				high = mid - 1;
			}
		}
		out.println(ans);
	}
	
	static boolean check(long mid) {
		long current = -100000000;
		int count = 0;
		for(pair x:p) {
			while(true) {
				if(Math.max(current + mid, x.start) > x.end) break;
				current = Math.max(current + mid, x.start);
				count++;
				if(count >= n) return true;
			}
		}
		return false;
	}

}

class pair implements Comparable<pair> {
	int start;
	int end;
	
	pair(int s, int e) {
		start = s;
		end = e;
	}
	
	public String toString() {
		return start + " " + end;
	}
	
	@Override
	public int compareTo(pair that) {
		if(this.start - that.start < 0) return -1;
		else if(this.start - that.start > 0) return 1;
		else {
			if(that.end - this.end < 0) return -1;
			else return 1;
		}
	}
}
