import java.util.*;
import java.io.*;

public class USACOBronzePractice3 {
	
	static Scanner in;
	static PrintWriter out;
		
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("BronzePractice3.in"));
		out = new PrintWriter(new File("BronzePractice2.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	public static void init() {
		
	}
	
	public static void solve() {
		int count =1;
        for(int i =0; i < hayley.length(); i++) {

            String temp = "";

            for(int j =0; j < hayley.length(); j++) {
                if(j+count <= hayley.length())
                temp += hayley.substring(j, j + count)+ " ";
            }
            System.out.println(temp);
            count++;
            list.add(temp);

        }
	}
	
}
