/*
ID: sechoi11
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new File("gift1.out"));
		
		int groupnum = Integer.parseInt(in.readLine());
		LinkedHashMap<String, Integer> acc = new LinkedHashMap<String, Integer>();
		for(int i = 0; i < groupnum; i++) {
			String name = in.readLine();
			acc.put(name, 0);
		}
		
		for(int i = 0; i < groupnum; i++) {
			String giver = in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			int amount = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			if(people == 0) continue;
			acc.put(giver, acc.get(giver) - amount);
			acc.put(giver, acc.get(giver) + (amount % people));
			for(int j = 0; j < people; j++) {
				String receiver = in.readLine();
				acc.put(receiver, acc.get(receiver) + (amount / people));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String name : acc.keySet()) {
			sb.append(name).append(" ").append(acc.get(name)).append("\n");
		}
		
		out.print(sb.toString());
		
		in.close();
		out.close();
	}

}
