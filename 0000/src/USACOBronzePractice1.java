import java.util.*;
import java.io.*;

public class USACOBronzePractice1 {
	
	static Scanner in;
	static PrintWriter out;
	static int[] num;
	static int result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("BronzePractice1.in"));
		out = new PrintWriter(new File("BronzePractice1.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		num = new int[4];
		for(int i = 0; i < 4; i++) {
			num[i] = in.nextInt();
		}
		result = 0;
	}
	
	public static void solve() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i != j) {
					for(int k=0;k<4;k++) {
						if(i!=k&&j!=k) {
							for(int l = 0; l<4; l++) {
								if(i!=l&&j!=l&&k!=l) {
									result ++;
								}
							}
						}
					}	
				}
			}
		}
		out.println(result);
	}
	
}