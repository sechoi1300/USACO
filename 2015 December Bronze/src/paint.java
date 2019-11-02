import java.util.*;
import java.io.*;

public class paint {
	
	static Scanner in;
	static PrintWriter out;
	static int[] wall = new int[100];
	static int a, b, c, d;
	static int total = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("paint.in"));
		out = new PrintWriter(new File("paint.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	public static void init() {
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		for(int i = a; i < b; i++) {
			wall[i] = 1;
		}
		for(int i = c; i < d; i++) {
			wall[i] = 1;
		}
	}
	
	public static void solve() {
		for(int i = 0; i < 100; i++) {
			if(wall[i] == 1) {
				total++;
			}
		}
		out.println(total);
	}
	
}
