import java.util.*;
import java.io.*;

public class shuffle {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int[] d, v;
	static int n, ans;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("shuffle.in"));
		out = new PrintWriter(new File("shuffle.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		d = new int[n];
		v = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken()) - 1;
			v[d[i]]++;
		}
		ans = n;
		q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			if(v[i] == 0) {
				q.add(i);
				ans--;
			}
		}
	}
	
	public static void solve() {
		while(!q.isEmpty()) {
			int curr = q.poll();
			v[d[curr]]--;
			if(v[d[curr]] == 0) {
				q.add(d[curr]);
				ans--;
			}
		}
		out.println(ans);
	}

}
