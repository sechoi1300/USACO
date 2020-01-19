import java.util.*;
import java.io.*;

public class Number_Practice_Pyramid {

	static Scanner in;
	static PrintWriter out;
	static int total, t, end, num, numcount, count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("Number_Practice_Pyramid.in"));
		out = new PrintWriter(new File("Number_Practice_Pyramid.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		t = in.nextInt();
		end = in.nextInt();
		num = 1;
		numcount = 1;
		count = 0;
	}

	public static void solve() {
		while(true) {
			total += num;
			count++;
			if(total >= t) break;
			if(num < end) num++;
			else if(numcount == 2) {
				num++;
				numcount = 1;
			} else {
				numcount++;
			}
		}
		out.println(count);
	}
	
}
