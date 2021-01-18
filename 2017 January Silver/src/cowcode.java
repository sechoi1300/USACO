import java.util.*;
import java.io.*;

public class cowcode {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("cowcode.in"));
		out = new PrintWriter(new File("cowcode.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
	}
	
	public static void solve() {
		
	}

}
