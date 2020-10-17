import java.util.*;
import java.io.*;

public class lifeguards {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n;
	static pair[] pairs;
	static Set<Integer> pool;
	static int current, past, id, total;
	static int[] alone;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("lifeguards.in"));
		out = new PrintWriter(new File("lifeguards.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		pairs = new pair[n * 2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int time1 = Integer.parseInt(st.nextToken());
			int time2 = Integer.parseInt(st.nextToken());
			pairs[i * 2] = new pair(time1, i);
			pairs[i * 2 + 1] = new pair(time2, i);
		}
		Arrays.sort(pairs);
		//System.out.println(Arrays.toString(pairs));
		pool = new HashSet<Integer>();
		alone = new int[n];
	}
	
	public static void solve() {
		for(int i = 0; i < pairs.length; i++) {
			current = pairs[i].time;
			id = pairs[i].id;
			if(!pool.isEmpty()) total+=(current - past);
			if(pool.size() == 1) alone[pool.hashCode()]+=(current - past);
			if(pool.contains(id)) pool.remove(id);
			else pool.add(id);
			past = current;
		}
		//System.out.println(total);
		//System.out.println(Arrays.toString(alone));
		int result = -1;
		for(int i = 0; i < n; i++) {
			result = Math.max(total - alone[i], result);
		}
		out.println(result);
	}
	
}
class pair implements Comparable<pair> {
	int time;
	int id;
	pair(int t, int i) {
		time = t;
		id = i;
	}
	public String toString() {
		return time + " : " + id;
	}
	@Override
	public int compareTo(pair that) {
		if(this.time > that.time) return 1;
		else if(this.time < that.time) return -1;
		else {
			if(this.id > that.id) return 1;
			else return -1;
		}
	}
}