import java.util.*;
import java.io.*;

public class square {
	
	static Scanner in;
	static PrintWriter out;
	static int[] x, y;
	static int xmin, ymin, xmax, ymax;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("square.in"));
		out = new PrintWriter(new File("square.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		x = new int[4];
		y = new int[4];
		for(int i = 0; i < 4; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		xmax = 0;
		ymax = 0;
		ymin = 10;
		xmin = 10;
	}

	public static void solve() {
		for(int i = 0; i < 4; i++) {
			xmax = Math.max(xmax, x[i]);
			xmin = Math.min(xmin, x[i]);
			ymax = Math.max(ymax, y[i]);
			ymin = Math.min(ymin, y[i]);
		}
		
		if(ymax - ymin > xmax - xmin) {
			out.println((ymax - ymin) * (ymax - ymin));
		} else {
			out.println((xmax - xmin) * (xmax - xmin));
		}
	}
	
}
