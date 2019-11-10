import java.util.*;
import java.io.*;

public class cowsignal {

	static Scanner in;
	static PrintWriter out;
	static int M, N, K;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("cowsignal.in"));
		out = new PrintWriter(new File("cowsignal.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		M = in.nextInt();
		N = in.nextInt();
		K = in.nextInt();
	}
	
	public static void solve() {
		String result = "";
	      
		for(int i = 0; i < M; i++) {
			String str = in.next();
            String temp = "";
                                 
			for(int j = 0; j < N; j++) {
			    char c = str.charAt(j);
			    for(int z=0; z < K; z++) {
			    	temp+=c;
			    }
			}
			for(int z = 0; z < K; z++) {
				result += temp + "\n";
			}
		}
      
      
      
      
      	out.print(result);
	}
	
}
