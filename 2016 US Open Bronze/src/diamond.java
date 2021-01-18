import java.io.*;
import java.util.*;

public class diamond {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("diamond.in"));
		out = new PrintWriter(new File("diamond.out"));
		
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
		int count = 0;
		int result = 0;
		for(int i = 0; i < n; i++) {
			int first = nums[i];
			for(int j = i; j < n; j++) {
				if(nums[j] - first <= k) {
					count++;
					//System.out.print(nums[j]);
				} else break;
			}
			result = Math.max(result, count);
			count = 0;
			//System.out.println();
		}
		out.println(result);
	}

}
