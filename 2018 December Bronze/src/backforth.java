import java.util.*;
import java.io.*;

public class backforth {
	
	static Scanner in;
	static String[] a;
	static String[] b;
	static String[] a1;
	static String[] b1;
	static Set<Integer> set;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("backforth.in"));
		out = new PrintWriter(new File("backforth.out"));
		
		String[] a = new String[10];
		String[] b = new String[10];
		a = in.nextLine().split(" ");
		b = in.nextLine().split(" ");
		
		int t1 = 1000;
		int t2 = 1000;
		
		String[] a1 = new String[10];
		String[] b1 = new String[10];
		a1 = a.clone();
		b1 = b.clone();
		
		set = new HashSet<Integer>();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				
				a = a1.clone();
				b = b1.clone();
				int milk = 1000 - Integer.parseInt(a[i]) + Integer.parseInt(b[j]);
				a[i] = b[j];
				b[j] = a1[i];
				
				for(int k = 0; k < 10; k++) {
					for(int m = 0; m < 10; m++) {
						int re = milk - Integer.parseInt(a[k]) + Integer.parseInt(b[m]);
						set.add(re);
					}
				}
				
			}
		}
		out.println(set.size());
		out.close();
	}
}
