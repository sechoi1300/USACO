import java.util.*;
import java.io.*;

public class mixmilk {
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("mixmilk.in"));
		out = new PrintWriter(new File("mixmilk.out"));
		
		int c1 = in.nextInt();
		int m1 = in.nextInt();
		int c2 = in.nextInt();
		int m2 = in.nextInt();
		int c3 = in.nextInt();
		int m3 = in.nextInt();
		
		for(int i = 0; i < 33; i++) {
			m2 += m1;
			if(m2 > c2) {
				m1 = m2 - c2;
				m2 = c2;
			} else {
				m1 = 0;
			}
			
			m3 += m2;
			if(m3 > c3) {
				m2 = m3 - c3;
				m3 = c3;
			} else {
				m2 = 0;
			}
			
			m1 += m3;
			if(m1 > c1) {
				m3 = m1 - c1;
				m1 = c1;
			} else {
				m3 = 0;
			}
			
			
		}
		
		m2 += m1;
		if(m2 > c2) {
			m1 = m2 - c2;
			m2 = c2;
		} else {
			m1 = 0;
		}
		
		out.println(m1);
		out.println(m2);
		out.println(m3);
		out.close();
		
	}
	
}
