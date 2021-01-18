import java.util.*;
import java.io.*;

public class convention2 {
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static PriorityQueue pq;
	static LinkedList<group> a = new LinkedList<group>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("convention2.in"));
		out = new PrintWriter(new File("convention2.out"));
		init();
		solve();
		out.close();
	}
	
	public static void init() throws IOException{
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a.add(new group(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		pq = new PriorityQueue<group>();
		Collections.sort(a, new Comparator<group>(){
			@Override
			public int compare(group x, group y) {
				if(x.arrival == y.arrival)
					return x.senior-y.senior;
				else
					return x.arrival-y.arrival;
			}
			
		});
	}
	
	public static void solve() throws IOException{
		group curr = a.remove(0);
		int time = curr.arrival+curr.eating;
		int wait = 0;
		while(!a.isEmpty() || !pq.isEmpty()) {
			//pq gets updated
			while(!a.isEmpty()) {
				curr = a.get(0);
				if(curr.arrival <= time) {
					pq.add(a.remove(0));
				}
				else
					break;
			}
			if(!pq.isEmpty()) {
				curr = (group) pq.poll();
				wait = Math.max(wait, time-curr.arrival);
				time += curr.eating;
			}
			else {
				curr = a.remove(0);
				wait = Math.max(wait, 0);
				time = curr.arrival + curr.eating;
			}
		}
		out.println(wait);
	}
}

class group implements Comparable<group>{
	int senior, arrival, eating;
	group(int s, int a, int e){
		senior = s;
		arrival = a;
		eating = e;
	}
	@Override
	public int compareTo(group that) {
		return this.senior-that.senior;
	}
}

