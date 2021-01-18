import java.util.*;
import java.io.*;

public class perimeter {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, area, maxarea, per, maxper;
	static char a[][];
	static boolean v[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("perimeter.in"));
		out = new PrintWriter(new File("perimeter.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		a = new char[n][n];
		v = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String temp = st.nextToken();
			for(int j = 0; j < n; j++) {
				a[i][j] = temp.charAt(j);
			}
		}
		//printBoard(a);
	}
	
	public static void solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == '#') {
					area = 0;
					per = 0;
					floodfill(i, j);
					if(maxarea == area) maxper = Math.min(maxper, per);
					else maxper = Math.max(maxper, per);
					maxarea = Math.max(maxarea, area);
				}
			}
		}
		out.println(maxarea + " " + maxper);
	}
	
	public static void floodfill(int x, int y) {
		// 3 options; boundary, non-land, visited
		if(x < 0 || x >= n || y < 0 || y >= n) {
			per++;
			return;
		}
		if(a[x][y] == '.') {
			per++;
			return;
		}
		if(v[x][y]) return;
		
		v[x][y] = true;
		area++;
		floodfill(x, y + 1);
		floodfill(x, y - 1);
		floodfill(x + 1, y);
		floodfill(x - 1, y);
	}
	
	public static void printBoard(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[i].length; j++) {
		        System.out.print(grid[i][j] + " ");
		    }
		     System.out.println();
		}
	}

}
