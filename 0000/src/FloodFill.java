/*
3 4
1 1 2 1
2 3 2 1
1 3 3 3
*/

import java.util.*;
import java.io.*;

public class FloodFill {
	static BufferedReader in;
	static PrintWriter out;
	static int n, m, a[][], ans, cnt;
	static boolean v[][];
	
	public static void main(String[] args) throws IOException {		
		in = new BufferedReader(new InputStreamReader(System.in));	
		init();
		solve();
		in.close();
	}
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    a = new int[n][m];
	    v = new boolean[n][m];
	    for(int i = 0; i < n; i++){
	    	st = new StringTokenizer(in.readLine());
	        for(int j = 0; j < m; j++){
	            a[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }	    
	}
	
	static void solve() {
	
		ans = 0;
		for(int i = 0; i < n; i++){
	        for(int j = 0; j < m; j++){ 
	            if(!v[i][j]){
	            	cnt=0;  
	                floodfill(i, j, a[i][j]);
	                System.out.println(a[i][j]+": "+cnt);
	                ans++;
	            }
	        }
		}
		
		System.out.println(ans);
	}
	
	static void floodfill(int x, int y, int color){
		
	    if(x < 0 || x >= n || y < 0 || y >= m) return; 	// if outside grid
	    if(a[x][y] != color) return; 					// wrong color
	    if(v[x][y]) return; 							// already visited this square
	    
	    
	    v[x][y] = true; 								// mark current square as visited
	    cnt++; 											// increment the size for each square we visit
	    
	    // recursively call floodfill for neighboring squares
	    floodfill(x, y+1, color);
	    floodfill(x, y-1, color);
	    floodfill(x-1, y, color);
	    floodfill(x+1, y, color);
	}
	
	public static void printBoard(String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[i].length; j++) {
		        System.out.print(grid[i][j] + " ");
		    }
		     System.out.println();
		}
	}	
}