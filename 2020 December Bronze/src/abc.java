import java.util.*;
import java.io.*;

public class abc {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int a, b, c;
	static ArrayList<Integer> nums;
	static int absum, bcsum, acsum, totalsum;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader (new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		nums = new ArrayList<Integer>();
		for(int i = 0; i < 7; i++) {
			nums.add(Integer.parseInt(st.nextToken())); 
		}
		Collections.sort(nums);
		//System.out.println(nums);
		a = nums.remove(0);
		totalsum = nums.remove(nums.size() - 1);
		bcsum = totalsum - a;
		nums.remove(nums.indexOf(bcsum));
		//System.out.println(nums);
		b = nums.remove(0);
		absum = a + b;
		nums.remove(nums.indexOf(absum));
		//System.out.println(nums);
		c = nums.remove(0);
		System.out.println(a + " " + b + " " + c);
	}
	
	public static void solve() {
		
	}

}
