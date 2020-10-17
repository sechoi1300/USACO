import java.util.*;
import java.io.*;

public class haybales {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, q;
	static int[] x;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("haybales.in"));
		st = new StringTokenizer(in.readLine());
		out = new PrintWriter(new File("haybales.out"));
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		x = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		//System.out.println(Arrays.toString(x));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());
			int temp = Integer.parseInt(st.nextToken());
			System.out.print(temp + ", ");
			int lower = Arrays.binarySearch(x, temp);
			if(lower < 0) lower = lower * -1 - 1;
			System.out.print(lower + " : ");
			temp = Integer.parseInt(st.nextToken());
			System.out.print(temp + ", ");
			int higher = Arrays.binarySearch(x, temp);
			if(higher >= 0 && higher <= n - 1 && temp == x[higher]) higher++;
			if(higher < 0) higher = higher * -1 -1;
			System.out.println(higher);
			sb.append(higher - lower).append("\n");
		}
		out.print(sb);
		out.close();
	}
	
	/*
	static int findub(int n) {
		int min = 0;
		int max = 6;
		int mid = 0;
		while(min <= max) {
			mid = (min + max) / 2;
			if(x[mid] == n) return mid;
			else if(x[mid] > n) max = mid - 1;
			else min = mid + 1;
		}
		return min;
	}
	
	static int findlb(int n) {
		int min = 0;
		int max = 6;
		int mid = 0;
		while(min <= max) {
			mid = (min + max) / 2;
			if(x[mid] == n) return mid;
			else if(x[mid] > n) max = mid - 1;
			else min = mid + 1;
		}
		return max;
	}
	*/
}
