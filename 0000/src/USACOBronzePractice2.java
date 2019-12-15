import java.util.*;
import java.io.*;

public class USACOBronzePractice2 {
	
	static Scanner in;
	static PrintWriter out;
	static int players, rounds, combo, win, loss;
	static int[][] games;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File("BronzePractice2.in"));
		out = new PrintWriter(new File("BronzePractice2.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		players = in.nextInt();
		rounds = in.nextInt();
		games = new int[rounds][players];
		for(int i = 0; i < rounds; i++) {
			for(int j = 0; j < players; j++) {
				games[i][j] = in.nextInt();
			}
		}
		win = 0;
		loss = 0;
	}
	
	public static void solve() {
		combo = 0;
		for(int i = players - 1; i > 0; i--) {
			combo += i;
		}
		for(int j = 0; j < players-1; j++) {
			for(int k = j + 1; k < players; k++) {
                for(int i = 0; i < rounds; i++) {
					if(games[i][j] != games[i][k] && games[i][j] > games[i][k]) {
						win++;
					}			
				}
              	out.println((j + 1) + " : " + (k + 1) + " = " + win + " : " + (4 - win));
				win = 0;
			}
		}
	}
	
}
