import java.util.*;
import java.io.*;

public class rut {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static cow[] cows;
	static int[] blame;

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
		blame = new int[n];
	}
	
	public static void solve() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int temp = check(i);
			blame[temp]++;
		}
		System.out.println(Arrays.toString(blame));
	}
	
	public static int check(int i) {
		int min = 1000000000;
		int temp = 0;
		if(cows[i].direction == 'E') {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				if(cows[j].direction == 'E') continue;
				if(cows[i].x > cows[j].x || cows[i].y < cows[j].y) continue;
				int dx = cows[j].x - cows[i].x;
				int dy = cows[i].y - cows[j].y;
				if(dx > dy && check(j) >= dy) {
					min = Math.min(min, dx);
					temp = j;
				}
			}
		} else {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				if(cows[j].direction == 'N') continue;
				if(cows[i].x < cows[j].x || cows[i].y > cows[j].y) continue;
				int dx = cows[i].x - cows[j].x;
				int dy = cows[j].y - cows[i].y;
				if(dx < dy && check(j) >= dx) {
					min = Math.min(min, dy);
					temp = j;
				}
			}
		}
		return temp;
	}

}

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
