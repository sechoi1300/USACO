import java.util.*;
import java.io.*;

public class cowdance {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	//static Queue<Integer> q;
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
		//q = new LinkedList<Integer>();
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		//System.out.println(n);
		//System.out.println(t);
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(nums));
	}
	
	public static void solve() {
		high = n;
		low = 1;
		ans = 0;
		mid = 0;
		while(low <= high) {
			mid = (high + low) / 2;
			if(check(mid)) {
				high = mid - 1;
				ans = (int) mid;
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
			int min = q.poll();
			if(min + nums[i] > t) return false;
			q.add(nums[i] + min);
		}
		return true;
	}
	
	/*
	public static void solve() {
		int size = 1;
		while(true) {
			//System.out.println(size);
			if(check(size)) {
				out.println(size);
				break;
			}
			size++;
		}
	}
	
	public static boolean check(int size) {
		q = new LinkedList<Integer>();
		for(int i = 0; i < size; i++) {
			q.add(nums[i]);
		}
		int compare = 0;
		for(int i = size; i < n; i++) {
			//System.out.println(q);
			int sub = q.peek();
			compare+=sub;
			for(int j = 0; j < q.size(); j++) {
				q.add(q.peek() - sub);
				q.poll();
			}
			q.poll();
			q.add(nums[i]);
		}
		//System.out.println(q);
		if(size > 1) {
			compare+=q.peek();
			int sub = q.peek();
			q.poll();
			compare+=q.peek() - sub;
			q.poll();
		}
		//System.out.println(q);
		//System.out.println(compare);
		if(compare <= t) return true;
		return false;
	}
	*/
	
}
