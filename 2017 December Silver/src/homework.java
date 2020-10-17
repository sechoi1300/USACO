import java.util.*;
import java.io.*;

public class homework {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n;
	static double[] scores, sums;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("homework.in"));
		out = new PrintWriter(new File("homework.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		scores = new double[n];
		for(int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		sums = new double[n];
		//System.out.println(n);
		//System.out.println(Arrays.toString(scores));
	}
	
	public static void solve() {
		double temp = 0;
		for(int i = n - 1; i >= 0; i--) {
			temp+=scores[i];
			sums[i] = temp;
		}
		//System.out.println(Arrays.toString(sums));
		double[] min = new double[n];
		temp = 100000000;
		for(int i = n - 1; i >= 0; i--) {
			temp = Math.min(temp, scores[i]);
			min[i] = temp;
		}
		//System.out.println(Arrays.toString(min));
		double divide = 1;
		for(int i = n - 2; i >= 1; i--) {
			sums[i]-=min[i];
			sums[i]/=divide;
			divide++;
		}
		//System.out.println(Arrays.toString(sums));
		double max = -100000000;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n - 2; i++) {
			if(sums[i] > max) {
				sb = new StringBuilder();
				sb.append("\n").append(i);
				max = Math.max(max, sums[i]);
			} else if(sums[i] == max) {
				sb.append("\n").append(i);
			} else {
				continue;
			}
		}
		out.println(sb.toString().substring(1));
	}

}