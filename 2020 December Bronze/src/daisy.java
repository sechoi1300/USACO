import java.util.*;
import java.io.*;

public class daisy {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static int[] petals;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader (new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		petals = new int[n];
		for(int i = 0; i < n; i++) {
			petals[i] = Integer.parseInt(st.nextToken()); 
		}
		//System.out.println(Arrays.toString(petals));
	}
	
	public static void solve() {
		int counter = 1;
		int result = 0;
		while(counter <= n) {
			int index = 0;
			for(int i = 0; i <= n - counter; i++) {
				double avg = 0;
				for(int j = i; j < i + counter; j++) {
					//sSystem.out.print(petals[j] + " ");
					avg+=(double)(petals[j]);
				}
				avg/=(double)(counter);
				//System.out.println();
				//System.out.println(avg);
				for(int j = i; j < i + counter; j++) {
					if(petals[j] == avg) {
						result++;
						break;
					}
				}
				//System.out.println();
			}
			counter++;
		}
		System.out.println(result);
	}

}
