import java.util.*;
import java.io.*;

public class rut {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static int[][] grid;
	static cow[] cows;

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
		cows = new cow[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int temp = i + 1;
			char d = st.nextToken().charAt(0);
			int xcor = Integer.parseInt(st.nextToken());
			int ycor = Integer.parseInt(st.nextToken());
			cows[i] = new cow(temp, d, xcor, ycor);
		}
		grid = new int[10000][10000];
		//System.out.println(Arrays.toString(cows));
	}
	
	public static void solve() {
		Set<Integer> skip = new HashSet<Integer>();
		int[] distance = new int[n];
		if(n == 1) {
			System.out.println("Infinity");
		} else {
			while(true) {
				for(cow c:cows) {
					if(skip.contains(c.num)) {
						//System.out.println("stop" + c.num);
						continue;
					}
					//System.out.println(c);
					//System.out.println(skip);
					grid[c.y][c.x] = -1 * c.num;
					if(c.direction == 'E') {
						c.x++;
					} else {
						c.y++;
					}
					distance[c.num - 1]++;
					/*
					if(c.y == 10000 || c.x == 10000) {
						skip.add(c.num);
						continue;
					}
					*/
					/*
					if(grid[c.y][c.x] < 0) {
						skip.add(c.num);
						continue;
					}
					if(c.num == 1 && grid[c.y][c.x] != 0) {
						skip.add(c.num);
						continue;
					}
					*/
					//grid[c.y][c.x] = c.num;
				}
				for(cow c:cows) {
					if(skip.contains(c.num)) {
						//System.out.println("stop" + c.num);
						continue;
					}
					if(c.y == 10000 || c.x == 10000) {
						skip.add(c.num);
						continue;
					}
					if(grid[c.y][c.x] < 0) {
						skip.add(c.num);
						continue;
					}
					grid[c.y][c.x] = c.num;
				}
				if(skip.size() == n) break;
			}
		}
		//System.out.println(Arrays.toString(distance));
		for(int i = 0; i < n; i++) {
			if(distance[i] >= 9990) {
				System.out.println("Infinity");
			} else {
				System.out.println(distance[i]);
			}
		}
	}

}
/*
class cow implements Comparable<cow> {
	int num;
	char direction;
	int x;
	int y;
	cow(int n, char d, int xcor, int ycor) {
		num = n;
		direction = d;
		x = xcor;
		y = ycor;
	}
	public String toString() {
		return num + " " + direction + " " + x + " " + y;
	}
	@Override
	public int compareTo(cow that) {
		return -1;
	}
}
*/