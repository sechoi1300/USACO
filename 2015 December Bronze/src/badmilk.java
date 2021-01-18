import java.io.*;
import java.util.*;

public class badmilk {

	static tri a[];
	static int N, M, D, S;
	static boolean b[], c[][];
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("badmilk.in"));
		out = new PrintWriter(new File("badmilk.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() {
		N = in.nextInt();
		M = in.nextInt();
		D = in.nextInt();
		S = in.nextInt();
		
		a = new tri[D+S];
		
		for(int i=0; i<D; i++)
			a[i] = new tri(in.nextInt()-1, in.nextInt()-1, in.nextInt());
		
		for(int i=D; i<S+D; i++)
			a[i] = new tri(in.nextInt()-1, -1, in.nextInt());
		
		Arrays.sort(a);
		
		b = new boolean[M];
		c = new boolean[N][M];
		Arrays.fill(b, true);	
	}
	
	static void solve() {
		//find bad milk
		for(tri data:a) {			
			if(data.milk==-1) 
				for (int j=0; j<M; j++)	b[j] = b[j] && c[data.id][j];
			
			else c[data.id][data.milk] = true;			
		}
		
		//count drank bad milk person
		int ans = 0;
        for (int i=0; i<M; i++) {

            if (b[i]) {
                int cnt = 0;
                for (int j=0; j<N; j++)  if (c[j][i]) cnt++;
                ans = Math.max(ans, cnt);
            }
        }		
		out.println(ans);
	}
}
class tri implements Comparable<tri>{

    public int id;
    public int milk;
    public int time;

    tri(int a, int b, int c) {
        id = a;
        milk = b;
        time = c;
    }   
    
    public String toString() {
    	return time+" "+id+" "+milk;
    }

	@Override
	public int compareTo(tri that) {
		if(this.time==that.time) return this.milk - that.milk;
		else return this.time - that.time;  //ascending
	}
}