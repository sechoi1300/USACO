import java.util.*;
import java.io.*;

public class socdist1 {

	static Scanner in;
	static PrintWriter out;
	static int N;
	static int[] stalls;
	static ArrayList<Integer> zeromaxes;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("socdist1.in"));
		out = new PrintWriter(new File("socdist1.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		N = Integer.parseInt(in.nextLine());
		stalls = new int[N];
		String temp = in.nextLine() + "1";
		for(int i = 0; i < N; i++) {
			stalls[i] = Integer.parseInt(temp.substring(i, i + 1));
		}
		zeromaxes = new ArrayList<Integer>();
	}
	
	public static void solve() {
		int tempzero = 0;
		for(int i = 0; i < stalls.length; i++) {
			if(stalls[i] == 0) {
				tempzero++;
			} else {
				zeromaxes.add(tempzero);
				tempzero = 0;
			}
			if(i == stalls.length - 1) {
				zeromaxes.add(tempzero);
				break;
			}
		}
		int max = 0;
		int maxindex = 0;
		for(int i = 0; i < zeromaxes.size(); i++) {
			if(zeromaxes.get(i) > max) {
				max = Math.max(max, zeromaxes.get(i));
				maxindex = i;
			}
		}
		int max2 = 0;
		for(int i = 0; i < zeromaxes.size(); i++) {
			if(i != maxindex) max2 = Math.max(max2, zeromaxes.get(i));
		}
		if((stalls[N - 1] == 0 && stalls[0] == 0) && (zeromaxes.get(0) == max || zeromaxes.get(zeromaxes.size() - 1) == max)) {
			if(max - 1 == 0 && max2 - 1 == 0) {
				out.println(1);
			} else if(max == max2) {
				out.println(max);
			} else if(max / 2 - 1 > max2 - 1) out.println(max / 2 - 1);
			else out.println(max2 - 1);
		} else if((stalls[N - 1] == 0 || stalls[0] == 0) && (zeromaxes.get(0) == max || zeromaxes.get(zeromaxes.size() - 1) == max)) {
			if(max - 1 == 0 && max2 - 1 == 0) {
				out.println(1);
			} else if(max2 == 0) {
				out.println((max - 1) / 2 + 1);
			} else {
				if((max - 1) / 2 > max2) out.println((max - 1) / 2 + 1);
				else out.println(max2 / 2);
			}
		} else {
			if(max - 1 == 0 && max2 - 1 == 0) {
				out.println(1);
			} else if(max == max2) {
				out.println((max - 1) / 2 + 1);
			} else if(max / 2 - 1 > max2 / 2) out.println(max / 3 + 1);
			else out.println(max2 / 2 + 1);
		}
		/*
			if(max / 2 > max2) {
				out.println(max / 2);
			} else {
				out.println(max2 - 1);
			}
		*/
	}

}
