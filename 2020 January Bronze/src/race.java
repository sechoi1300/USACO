import java.util.*;
import java.io.*;

public class race {
	
	static Scanner in;
	static PrintWriter out;
	static int N, total, t, num, numcount, count;
	static int[] end;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("race.in"));
		out = new PrintWriter(new File("race.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		t = in.nextInt();
		N = in.nextInt();
		end = new int[N];
		for(int i = 0; i < 5; i++) {
			end[i] = in.nextInt();
		}
		num = 1;
		numcount = 1;
		count = 0;
	}
	
	public static void solve() {
		for(int i = 0; i < N; i++) {
			while(true) {
				total += num;
				count++;
				if(total >= t) break;
				if(num < end[i]) num++;
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

}
