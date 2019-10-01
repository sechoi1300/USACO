import java.util.*;
import java.io.*;

public class shell {

	static Scanner in; 
  	static PrintWriter out;
	static int N, score, pebbles[], a[], b[], g[], max;

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("shell.in"));
		out = new PrintWriter(new File("shell.out"));
		
		init();
		solve();
      
        in.close();
        out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		a = new int[N];
		b = new int[N];
		g = new int[N];
		max = 0;
		for(int i = 0; i < N; i++) {
			a[i] = (in.nextInt() - 1);
			b[i] = (in.nextInt() - 1);
			g[i] = (in.nextInt() - 1);
		}
	}
	
	public static void solve() {
		for(int i = 0; i < 3; i++) {
			reset(i);
			game();
			max = Math.max(max, score);			
		}
		out.println(max);
		out.close();
	}
	
	public static void reset(int i) {
		pebbles = new int[3];
		pebbles[i] = 1;
		score = 0;
	}
	
	public static void game() {
		for(int i = 0; i < N; i++) {
			int temp = pebbles[a[i]];
			pebbles[a[i]] = pebbles[b[i]];
			pebbles[b[i]] = temp;
			if(pebbles[g[i]] == 1) {
				score += 1;
			}
		}
	}
	
}
