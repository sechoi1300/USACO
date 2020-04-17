/*
ID: sechoi11
LANG: JAVA
TASK: test
*/
import java.util.*;
import java.io.*;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("test.in"));
		PrintWriter out = new PrintWriter(new File("test.out"));
		
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		
		out.println(num1 + num2);
		
		in.close();
		out.close();
	}

}
