/*
ID: sechoi11
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;

public class ride {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("ride.in"));
		PrintWriter out = new PrintWriter(new File("ride.out"));
		
		String comet = in.next();
		String group = in.next();
		
		int cometnum = comet.charAt(0) - 64;
		int groupnum = group.charAt(0) - 64;
		
		for(int i = 1; i < comet.length(); i++) {
			cometnum*=(comet.charAt(i) - 64);
		}
		
		for(int i = 1; i < group.length(); i++) {
			groupnum*=(group.charAt(i) - 64);
		}
		
		if(cometnum % 47 == groupnum % 47) out.println("GO");
		else out.println("STAY");
		
		in.close();
		out.close();
	}

}
