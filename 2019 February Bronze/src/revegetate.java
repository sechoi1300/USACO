import java.util.*;
import java.io.*;

public class revegetate {
	
	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static ArrayList<String>[] f;
	static String[] g;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("revegetate.in"));
		out = new PrintWriter(new File("revegetate.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		n = in.nextInt();
		m = in.nextInt();
		f = new ArrayList[n];
		for(int i = 0; i < m; i++) {
			f[i] = new ArrayList<String>();
		}
		for(int i = 0; i < m; i++) {
			f[in.nextInt() - 1](i+"");
			f[in.nextInt() - 1](i+"");
		}
		seeds = new String[] {"1","1234","1234","1234"};
	}
	
	public static void solve() {
		for(int i = 0; i < n; i++) {
			
		}
		//
		for(int i = 1; i < n; i++) {
			seeds[i] = seeds[i].substring(0, 1);
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < )
			}
		}
	}

}
/*
 import java.util.*;
import java.io.*;
public class revegetate {
	static Scanner in;
	static PrintWriter out;
	static ArrayList<String>[] f
    static String[] g;
	static int n, m;
	public static void main(String[] args) {
		try {
			init();
			solve();
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() throws IOException{
		in = new Scanner(new File("revegetate.in"));
		out = new PrintWriter(new File("revegetate.out"));
		n = in.nextInt();
		m = in.nextInt();
	
		g = new String[n];
		Arrays.fill(g, "1234");
	    
        f = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			f[i] = new ArrayList<String>();
		}
      
        for(int i = 0; i < m; i++) {
			f[in.nextInt()-1].add(i+"");
            f[in.nextInt()-1].add(i+"");
		}      
	}
	
	private static void solve() throws IOException{
		for(int i = 0; i < n; i++) {
			g[i] = g[i].charAt(0)+"";
			for(int j = 0; j < f[i].size(); j++) {
				for(int k = i+1; k < n; k++) {
					if(past[k].contains(past[i].get(j))) {
					   a[k] = a[k].replace(a[i], "");
					   System.out.println(Arrays.toString(a));
					}
				}
			}
		}
		String res = "";
		for(int i = 0; i < n; i++) {
			res += a[i];
		}
		out.println(res);
	}
}
*/