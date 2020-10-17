import java.util.*;
import java.io.*;

public class socdist {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m;
	static long high, low, mid;
	static int ans;
	static data[] a;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("socdist.in"));
		st = new StringTokenizer(in.readLine());
		out = new PrintWriter(new File("socdist.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException{
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new data[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		for(int i = 0; i < m; i++) {
			//System.out.println(a[i]);
		}
	}
	
	public static void solve() {
		high = 10000000;
		low = -1;
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
		
		for(data x:a) {
			while(true) {
				if(Math.max(current + mid, x.start) > x.end) break;
				current = Math.max(current + mid, x.start);
				count++;
				if(count >= n) return true;
			}
		}
		return false;
	}
	
	static class data implements Comparable<data> {
		int start;
		int end;
		
		data(int inputstart, int inputend) {
			start = inputstart;
			end = inputend;
		}
		
		public String toString() {
			return start + " " + end;
		}
		
		@Override
		public int compareTo(data that) {
			if(this.start - that.start < 0) return -1;
			else if(this.start - that.start > 0) return 1;
			else {
				if(that.end - this.end < 0) return -1;
				else return 1;
			}
		}
	}

}
