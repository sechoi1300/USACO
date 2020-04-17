import java.util.*;
import java.io.*;

public class socdist2 {

	static Scanner in;
	static PrintWriter out;
	static int N;
	static TreeMap<Integer, Integer> a;
	static int[] cowlist;
	static int R;
	static int count;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("socdist2.in"));
		out = new PrintWriter(new File("socdist2.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = Integer.parseInt(in.nextLine());
		a = new TreeMap<Integer, Integer>();
		for(int i = 0; i < N; i++) {
			int key = in.nextInt();
			int value = in.nextInt();
			a.put(key, value);
		}
		//System.out.println(a);
		cowlist = new int[a.lastKey()];
		for(int i : a.keySet()) {
			if(a.get(i) == 1) cowlist[i - 1] = 1;
		}
		//System.out.println(Arrays.toString(cowlist));
		R = 1000000000;
	}
	
	public static void solve() {
		for(int i : a.keySet()) {
			for(int j : a.keySet()) {
				if(i != j && j > i) {
					if(a.get(j) == 0 && a.get(i) == 1) R = Math.min(R, j - i);
				}
			}
		}
		//R-=1;
		count = 0;
		for(int i : a.keySet()) {
			for(int j : a.keySet()) {
				if(i != j && j > i) {
					if(a.get(i) == 1 && a.get(j) == 1) {
						if(Math.abs(j - i) < R) {
							count--;
						}
					} else if(a.get(i) == 1 || a.get(j) == 1) {
						count++;
					}
				}
			}
		}
		out.println(count);
	}

}
