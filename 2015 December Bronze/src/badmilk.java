import java.util.*;
import java.io.*;

public class badmilk {
	
	static Scanner in;
	static PrintWriter out;
	static int N, M, D, S;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("badmilk.in"));
		out = new PrintWriter(new File("badmilk.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		M = in.nextInt();
		D = in.nextInt();
		S = in.nextInt();
		for(int i = 0; i < D; i++) {
			
		}
	}
	
	public static void solve() {
		
	}
	
}

/*ArrayList<Integer> [] a = new ArrayList[3];


for(int i=0; i<3; i++){
  a[i] = new ArrayList<Integer>();
}

a[0].add(0);
*/