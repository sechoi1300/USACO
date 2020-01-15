import java.util.*;
import java.io.*;

public class herding {

	static Scanner in;
	static PrintWriter out;
	static int[] input;
	static int min, max;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("herding.in"));
		out = new PrintWriter(new File("herding.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		input = new int[3];
		for(int i = 0; i < 3; i++) {
			input[i] = in.nextInt();
		}
		Arrays.sort(input);
	}
	
	public static void solve() {
		if(input[0] == input[1] - 1 && input[1] == input[2] - 1) min = 0;
		else if(input[0] == input[1] - 2 || input[1] == input[2]  - 2) min = 1;
      	else min = 2;
		max = (Math.max(input[2] - input[1], input[1] - input[0])) - 1;
		out.print(min + "\n" + max);
	}

}