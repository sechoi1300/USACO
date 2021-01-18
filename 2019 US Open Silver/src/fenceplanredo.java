import java.util.*;
import java.io.*;

public class fenceplanredo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m;
	static cow[] a;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("fenceplanredo.in"));
		out = new PrintWriter(new File("fenceplanredo.out"));
		
		init();
		
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new cow[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int xin = Integer.parseInt(st.nextToken());
			int yin = Integer.parseInt(st.nextToken());
			a[i] = new cow(xin, yin);
		}
	}
	
	public static void solve() {
		
	}

}

class cow implements Comparable<cow> {
	int x;
	int y;
	cow(int xin, int yin) {
		x = xin;
		y = yin;
	}
	public String toString() {
		return x + " " + y;
	}
	@Override
	public int compareTo(cow that) {
		if(this.x > that.x) return 1;
		else if(this.x < that.x) return -1;
		else {
			if(this.y > that.y) {
				return 1;
			} else return -1;
		}
	}
}