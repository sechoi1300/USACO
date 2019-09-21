import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class blist {
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("blist.in"));
		out = new PrintWriter(new File("blist.out"));
		
		int N = in.nextInt();
		int[] a = new int[1001];
		
		for(int i = 0; i < N; i++) {
			int si = in.nextInt();
			int ti = in.nextInt();
			int bi = in.nextInt();
			
			for(int j = si; j <= ti; j++) {
				a[j] += bi;
			}
		}
		Arrays.sort(a);
		out.println(a[1000]);
		out.close();
	}

}
