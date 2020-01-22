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
		/*
		length = str.length();
		for(int i = 0; i < N; i++) {
			if(length + words[i].length() > K) {
				str = str + "\n" + words[i];
				length = words[i].length();
			} else {
				str = str + " " + words[i];
				length = str.length();
			}
		}
		System.out.println(str.substring(1, str.length()));
		*/
		str = words[0];
        result = "";
		for(int i = 1; i < N; i++) {
            
            if(str.length() + words[i].length() > K) {
              result +=str+"\n";
              str= words[i];
            }
          
            else {
              str += " "+words[i];
            }
            			
		}
		out.print(result + words[N - 1]);
	}
	
}
