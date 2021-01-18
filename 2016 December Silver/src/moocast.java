import java.util.*;
import java.io.*;

public class moocast {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n;
	static cow[] a;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("moocast.in"));
		out = new PrintWriter(new File("moocast.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		a = new cow[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int xin = Integer.parseInt(st.nextToken());
			int yin = Integer.parseInt(st.nextToken());
			int pin = Integer.parseInt(st.nextToken());
			a[i] = new cow(xin, yin, pin);
		}
		v = new boolean[n];
	}
	
	public static void solve() {
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(!v[i]) {
				ans = Math.max(ans, solve1(i));
			}
		}
	}
	
	public static int solve1(int i) {
		v = new boolean[n];
		dfs(i);
		int count = 0;
		for(int j = 0; j < n; j++) {
			if(v[i]) count++;
		}
		return count;
	}
	
	public static void dfs(int s) {
		v[s] = true;
		for(int i = 0; i < n; i++) {
			double distance = Math.sqrt( Math.pow(a[s].x - a[i].x, 2) + Math.pow(a[s].y - a[i].y, 2) );
			if(distance <= a[s].p) {
				dfs(i);
			}
		}
	}

}

class cow implements Comparable<cow> {
	int x;
	int y;
	int p;
	cow(int xin, int yin, int pin) {
		x = xin;
		y = yin;
		p = pin;
	}
	public String toString() {
		return x + " " + y + " " + p;
	}
	@Override
	public int compareTo(cow that) {
		if(this.x > that.x) return 1;
		else if(this.x > that.x) return -1;
		else {
			if(this.y > that.y) return 1;
			else return -1;
		}
	}
}