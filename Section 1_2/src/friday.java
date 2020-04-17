/*
ID: sechoi11
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;

public class friday {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new File("friday.out"));
		
		int years = Integer.parseInt(in.readLine());
		int[] month = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] days = new int[7];
		int date = 13;
		
		for(int i = 1900; i < 1900 + years; i++) {
			for(int j = 1; j <= 12; j++) {
				days[date % 7]++;
				date+=month[j];
				if(j == 2 && isLeap(i)) date++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(days[6]).append(" ").append(days[0]).append(" ");
		for(int i = 1; i < 5; i++) {
			sb.append(days[i]).append(" ");
		}
		sb.append(days[5]).append("\n");
		
		out.print(sb.toString());
		
		in.close();
		out.close();
	}
	
	static boolean isLeap(int n) {
		double num = (double)(n);
		if(num % 100 == 0) {
			if(num % 400 == 0) return true;
			else return false;
		}
		if(num % 4 == 0) return true;
		else return false;
	}

}
