import java.util.*;
import java.io.*;

public class lemonade {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("lemonade.in"));
		out = new PrintWriter(new File("lemonade.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
	}
	
	public static void solve() {
		int tracker = 0;
		for(int i = nums.length - 1; i >= 0; i--) {
			if(nums[i] < tracker) break;
			tracker++;
		}
		out.println(tracker);
	}
	
}
