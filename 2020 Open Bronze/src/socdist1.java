import java.util.*;
import java.io.*;

public class socdist1 {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static ArrayList<Integer> a;
	static int low, high, mid;
	static int ans;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("socdist1.in"));
		out = new PrintWriter(new File("socdist1.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = Integer.parseInt(in.nextLine());
		a = new ArrayList<Integer>();
		String temp = in.nextLine();
		for(int i = 0; i < N; i++) {
			if(temp.charAt(i) == '1') a.add(i);
		}
		low = 1;
		high = N - 1;
		for(int i = 0; i < a.size() - 1; i++) {
			high = Math.min(a.get(i + 1) - a.get(i), high);
		}
		System.out.println(a);
		System.out.println(low + " " + high);
	}
	
	public static void solve() {
		if(a.size() == 0) {
			out.println(N - 1);
			return;
		}
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			//System.out.println(mid);
		}
		out.println(ans);
	}
	
	static boolean check(int num) {
		/*
		int cows = 0;
		int distance = num;
		for(int i = 0; i < a.size() - 1; i++) {
			int previous = a.get(i);
			int next = a.get(i + 1);
			while(previous + distance < next) {
				previous = previous + distance;
				cows++;
			}
			previous = next;
		}
		return cows >= 2;
		*/
		int cows = a.get(0) / num + (N - 1 - a.get(a.size() - 1)) / num;
		int pre = 0;
		int next = 0;
		for(int i = 0; i < a.size(); i++) {
			//if(a.get(i + 1) - a.get(i) >= num * 2) cows++;
			next = a.get(i);
			boolean flag = false;
			while(pre + num <= next) {
				flag = true;
				pre = pre + num;
				cows++;
			}
			if(flag) cows--;
			pre = next;
		}
		//System.out.println(cows);
		return cows >= 2;
	}

}
