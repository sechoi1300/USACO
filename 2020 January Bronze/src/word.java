import java.util.*;
import java.io.*;

public class word {
	
	static Scanner in; 
  	static PrintWriter out;
  	static int N, K, length;
  	static String[] words;
  	static String str, result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("word.in"));
		out = new PrintWriter(new File("word.out"));
		
		init();
		solve();
      
        in.close();
        out.close();
	}
	
	public static void init() {
		N = in.nextInt();
		K = in.nextInt();
		words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = in.next();
		}
		str = "";
	}
	
	public static void solve() {
		length = words[0].length();
        String result = words[0];
		for(int i = 1; i < N; i++) {
			length += words[i].length();
            if(length <= K) {
            	result += " "+words[i];                  
            }          
            else {
              result +="\n"+words[i];
              length=words[i].length();
            }             
		}
		out.println(result);
	}
	
}
