import java.util.*;
import java.io.*;

public class convention2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n;
	static LinkedList<group> a;
	static PriorityQueue pq;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("convention2.in"));
		st = new StringTokenizer(in.readLine());
		out = new PrintWriter(new File("convention2.out"));
		
		n = Integer.parseInt(st.nextToken());
		a = new LinkedList<group>();
		pq = new PriorityQueue<group>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a.add(new group(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(a, new Comparator<group>() {
			@Override
			public int compare(group o1, group o2) {
				// TODO Auto-generated method stub
				if(o1.arrival == o2.arrival) return o1.seniority - o2.seniority;
				return o1.arrival - o2.arrival;
			}
		});
		//System.out.println(a);
		
	}

}

class group implements Comparable<group> {
	int seniority;
	int arrival;
	int eattime;
	group(int s, int a, int e) {
		seniority = s;
		arrival = a;
		eattime = e;
	}
	public String toString() {
		return "Seniority: " + seniority + " Arrival Time: " + arrival + " Eat Time: " + eattime + "\n";
	}
	@Override
	public int compareTo(group that) {
		return this.seniority - that.seniority;
	}
}