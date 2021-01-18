import java.util.*;
import java.io.*;

public class socdist2redo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, low, high, mid, ans;
	static pair[] p;
	static ArrayList<Integer> sick;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("socdist2.in"));
		out = new PrintWriter(new File("socdist2.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		p = new pair[n];
		sick = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int xn = Integer.parseInt(st.nextToken());
			int sn = Integer.parseInt(st.nextToken());
			p[i] = new pair(xn, sn);
			if(sn == 1) sick.add(xn);
		}
		Arrays.sort(p);
		Collections.sort(sick);
		low = 1;
		high = sick.get(sick.size() - 1) - sick.get(0);
	}
	
	public static void solve() {
		int r = sick.get(sick.size() - 1) - sick.get(0);
		for(int i = 0; i < p.length - 1; i++) {
			if(p[i].s == 0 && p[i + 1].s == 1) {
				r = Math.min(r, Math.abs(p[i + 1].x - p[i].x));
			} else if(p[i].s == 1 && p[i + 1].s == 0) {
				r = Math.min(r, Math.abs(p[i + 1].x - p[i].x));
			} else {
				continue;
			}
		}
		r--;
		//System.out.println(r);
		int count = 0;
		for(int i = 0; i < sick.size() - 1; i++) {
			while(true) {
				if(sick.get(i) + r >= sick.get(i + 1)) {
					i++;
				} else {
					break;
				}
				if(i >= sick.size() - 1) break;
			}
			count++;
		}
		if(sick.get(sick.size() - 1) - sick.get(sick.size() - 2) > r) {
			count++;
		}
		out.println(count);
	}

}

class pair implements Comparable<pair> {
	int x;
	int s;
	
	pair(int xn, int sn) {
		x = xn;
		s = sn;
	}
	
	public String toString() {
		return x + " " + s;
	}
	
	@Override
	public int compareTo(pair that) {
		if(this.x - that.x < 0) return -1;
		else if(this.x - that.x > 0) return 1;
		else {
			if(this.s - that.s < 0) return -1;
			else return 1;
		}
	}
}
