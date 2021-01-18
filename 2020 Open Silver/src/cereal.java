import java.util.*;
import java.awt.Checkbox;
import java.io.*;

public class cereal {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m;
	static int[][] cows;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("cereal.in"));
		out = new PrintWriter(new File("cereal.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cows = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 2; j++) {
				int temp = Integer.parseInt(st.nextToken());
				cows[i][j] = temp;
			}
		}
		/*
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(cows[i]));
		}
		*/
	}
	
	public static void solve() {
		/*
		for(int i = 0; i < n; i++) {
			 out.println(check(i));
		}
		*/
		boolean[] box = new boolean[m];
		Arrays.fill(box, true);
		int count = 0;
		String str = "";
		for(int i = n - 1; i >= 0; i--) {
			if(box[cows[i][0] - 1]) {
				count++;
				box[cows[i][0] - 1] = false;
			} else if(box[cows[i][1] - 1]) {
				count++;
				box[cows[i][1] - 1] = false;
			}
			str = count + "\n" + str;
		}
		out.println(str.substring(0, str.length() - 1));
	}
	
	public static int check(int num) {
		//present to past
		boolean[] box = new boolean[m];
		Arrays.fill(box, true);
		//System.out.println(Arrays.toString(box));
		int count = 0;
		for(int i = num; i < n; i++) {
			if(box[cows[i][0] - 1]) {
				count++;
				box[cows[i][0] - 1] = false;
			} else if(box[cows[i][1] - 1]) {
				count++;
				box[cows[i][1] - 1] = false;
			} else {
				continue;
			}
		}
		return count;
	}

}
