import java.util.*;
import java.io.*;

public class convention {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, c;
	static int[] cows;
	static int low, high, mid, ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("convention.in"));
		st = new StringTokenizer(in.readLine());
		out = new PrintWriter(new File("convention.out"));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cows = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		//System.out.println(Arrays.toString(cows));
		solve();
	}
	
	public static void solve() {
		low = 0;
		high = cows[cows.length - 1] - cows[0];
		ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(ans);
		out.println(ans);
		out.close();
	}
	
	public static boolean check(int mid) {
		int bus = 1;
		int fill = 0;
		int temp = cows[0];
		//System.out.print(temp + " ");
		for(int i = 0; i < n; i++) {
			//System.out.print(temp + " ");
			if(cows[i] - temp <= mid) {
				fill++;
				//System.out.print(cows[i] + " ");
			}
			if(fill > c || cows[i] - temp > mid) {
				bus++;
				//System.out.println();
				temp = cows[i];
				//System.out.println(temp + " ");
				fill = 1;
			}
			//check to see if under min wait time, then if filled up
			/*
			while(true) {
				if(cows[i + 1] - temp <= mid) {
					System.out.print(cows[i + 1] + " ");
					fill++;
					i++;
				}
				if(i >= n - 1 || fill > c || cows[i + 1] - temp > mid) {
					System.out.println();
					break;
				}
			}
			bus++;
			fill = 1;
			*/
		}
		return bus <= m;
	}

}
