import java.util.*;
import java.io.*;

public class photo {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static int[] num;
	static LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("photo.in"));
		out = new PrintWriter(new File("photo.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = in.nextInt();
        num = new int[N - 1];
        for(int i = 0; i < N - 1; i++) {
          num[i] = in.nextInt();
		}
		//System.out.println(Arrays.toString(num));
	}
	
	public static void solve() {
		int[] result = new int[N + 1];
		int temp = 1;
		while(true) {
			result[0] = temp;
			set.add(temp);
			for(int i = 0; i < N - 1; i++) {
				temp = num[i]- temp;
				set.add(temp);
				result[i + 1] = temp;
			}
			if(set.size() == N) break;
			temp++;
			set.clear();
		}
		String str = "";
		for(int i = 0; i < N; i++) {
			str+=" " + result[i];
		}
		out.println(str.substring(1));
	}

}
