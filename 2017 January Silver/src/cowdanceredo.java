import java.util.*;
import java.io.*;

public class cowdanceredo {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, t;
	static int[] nums;
	static int high, low, mid, ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("cowdance.in"));
		out = new PrintWriter(new File("cowdance.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(nums));
	}
	
	public static void solve() {
		low = 1;
		high = n;
		ans = 0;
		while(low <= high) {
			mid = (high + low) / 2;
			if(check(mid)) {
				high = mid - 1;
				ans = mid;
			} else low = mid + 1;
		}
		out.println(ans);
	}
	
	public static boolean check(int mid) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < mid; i++) {
			q.add(nums[i]);
		}
		for(int i = mid; i < nums.length; i++) {
			int temp = q.poll();
			if(temp + nums[i] > t) return false;
			q.add(nums[i] + temp);
		}
		return true;
	}

}
