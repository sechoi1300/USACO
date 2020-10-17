import java.util.*;
import java.io.*;

public class socdist2 {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static data[] a;
	static ArrayList<Integer> infected;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("socdist2.in"));
		out = new PrintWriter(new File("socdist2.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = Integer.parseInt(in.nextLine());
		a = new data[N];
		infected = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			int pos = in.nextInt();
			int stat = in.nextInt();
			a[i] = new data(pos, stat);
			if(stat == 1) infected.add(pos);
			//System.out.println(a[i].status);
			//System.out.println(pos + " " + stat);
		}
		Arrays.sort(a);
		Collections.sort(infected);
		//System.out.println(Arrays.toString(a));
		//System.out.println(infected);
	}
	
	public static void solve() {
		int min = 1000000000;
		for(int i = 0; i < a.length - 1; i++) {
			//System.out.println(a[i + 1].position + " " + a[i].position);
			if((a[i].status ^ a[i + 1].status) == 1) min = Math.min(min, a[i + 1].position - a[i].position);
		}
		min--;
		//System.out.println(min);
		int count = 0;
		int temp = a[0].position;
		for(int i = 0; i < infected.size() - 1; i++) {
			while(true) {
				if(infected.get(i) + min >= infected.get(i + 1)) {
					i++;
				} else {
					break;
				}
				if(i >= infected.size() - 1) break;
			}
			count++;
		}
		if(infected.get(infected.size() - 1) - infected.get(infected.size() - 2) > min) count++;
		out.println(count);
	}
	
	static class data implements Comparable<data> {
		int position;
		int status;
		
		data(int posinput, int statinput) {
			position = posinput;
			status = statinput;
		}
		
		public String toString() {
			return position + " : " + status;
		}
		
		@Override
		public int compareTo(data that) {
			if(this.position - that.position < 0) return -1;
			else if(this.position - that.position > 0) return 1;
			else {
				if(this.status - that.status < 0) return -1;
				else return 1;
			}
		}
	}

}
