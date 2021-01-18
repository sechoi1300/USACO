import java.util.*;
import java.io.*;

public class haybalesredo {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, q;
	static int[] pos;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("haybales.in"));
		out = new PrintWriter(new File("haybales.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		pos = new int[n];
		for(int i = 0; i < n; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pos);
	}
	
	public static void solve() throws IOException{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			int lowx = Arrays.binarySearch(pos, low);
			int highx = Arrays.binarySearch(pos, high);
			if(lowx < 0) lowx = Math.abs(lowx) - 1;
			if(highx < 0) highx = Math.abs(highx) - 2;
			sb.append(highx - lowx + 1).append("\n");
		}
		out.print(sb);
	}

}
