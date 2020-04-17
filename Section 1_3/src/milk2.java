/*
ID: sechoi11
LANG: JAVA
TASK: milk2
*/
import java.util.*;
import java.io.*;

public class milk2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new File("milk2.out"));
		
		int N  = Integer.parseInt(in.readLine());
		pair[] time = new pair[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			time[i] = new pair(x, y);
		}
		
		int continuous = 0;
		int none = 0;
		
		/*
		if(time.length > 1) {
			for(int i = 0; i < N - 1; i++) {
				continuous = Math.max(continuous, time[i].end - time[i].start);
				continuous = Math.max(continuous, time[i + 1].end - time[i + 1].start);
				if(time[i].end < time[i + 1].start) {
					none = Math.max(none, time[i + 1].start - time[i].end);
				} else {
					continuous = Math.max(continuous, time[i + 1].end - time[i].start);
				}
			}
		} else {
			continuous = time[0].end - time[0].start;
		}
		*/
		
		boolean[] schedule = new boolean[time[N - 1].end + 1];
		
		for(int i = 0; i < N; i++) {
			for(int j = time[i].start; j <= time[i].end; j++) {
				schedule[j] = true;
			}
		}
		
		int True = 0;
		int False = 0;
		int i = time[0].start;
		while(true) {
            int t = 0;
            int f = 0;
            while(true) {
                if(schedule[i]) t++;
                i++;
                if(i >= schedule.length || !schedule[i]) break;
            }
            i--;
            while(true) {
                if(!schedule[i]) f++;
                i++;
                if(i >= schedule.length || schedule[i]) break;
            }
            True = Math.max(True, t);
            False = Math.max(False, f);
            
            if(i >= schedule.length) break;
		}
			
		out.println(True + " " + False);
		
		in.close();
		out.close();
	}
	
}

class pair implements Comparable<pair> {
	int start;
	int end;
	pair(int s, int e) {
		start = s;
		end = e;
	}
	@Override
	public int compareTo(pair that) {
		if(this.start == that.start) return this.end - that.end;
		return this.start - that.start;
	}
	public String toString() {
		return start + " " + end;
	}
}