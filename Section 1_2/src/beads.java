/*
ID: sechoi11
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

public class beads {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new File("beads.out"));
		
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		char[] necklace = new char[N * 2];
		int index = 0;
		for(int i = 0; i < N * 2; i++) {
			necklace[i] = str.charAt(index);
			index++;
			if(index == str.length()) index = 0;
		}
		ArrayList<Integer> maxes = new ArrayList<Integer>();
		for(int i = 0; i < str.length(); i++) {
			boolean changed = false;
			int count = 0;
			char c = str.charAt(i);
			for(int j = i+1; j < necklace.length - str.length() + i; j++) {
				count++;
				if(c == 'w') {
					c = necklace[j];
					continue;
				}
				if(j == necklace.length - str.length() + i - 1) {
					maxes.add(str.length());
					count = 0;
					break;
				}
				if(necklace[j] == 'w') continue;
				else if(c != necklace[j]) {
					if(!changed) {
						changed = true;
						c = necklace[j];
					}
					else {
						maxes.add(count);
						count = 0;
						break;
					}
				} else {
					continue;
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < maxes.size(); i++) {
			max = Math.max(max, maxes.get(i));
		}
		
		if(max == 0) out.println(str.length());
		else if(max >= str.length()) out.println(str.length());
		else out.println(max);
		
		System.out.println(Arrays.toString(necklace));
		System.out.println(maxes);
		
		in.close();
		out.close();
	}
	
}
