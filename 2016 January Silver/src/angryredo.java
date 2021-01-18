import java.util.*;
import java.io.*;

public class angryredo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k;
	static int[] nums;
	static int low, high, mid, ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("angry.in"));
		out = new PrintWriter(new File("angry.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
	}
	
	public static void solve() {
		low = 1;
		high = nums[nums.length - 1] - nums[0];
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				high = mid - 1;
				ans = mid;
			} else {
				low = mid + 1;
			}
		}
		out.println(ans);
	}
	
	public static boolean check(int mid) {
		int range = mid * 2 + nums[0];
		int count = 1;
		for(int i = 1; i < n; i++) {
			if(nums[i] <= range) continue;
			else {
				count++;
				range = mid * 2 + nums[i];
			}
		}
		return count <= k;
	}

}
