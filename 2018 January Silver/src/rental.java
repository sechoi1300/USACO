import java.util.*;
import java.io.*;
public class rental {
	static BufferedReader in;
	static PrintWriter out;
	static int n, m, r;
	static long result;
	static int[] cow, rental;
	static TreeMap<Integer, Integer> shop = new TreeMap<Integer, Integer>();
	static long[] profit;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("rental.in"));
		out = new PrintWriter(new File("rental.out"));
		init();
		solve();
		out.close();
	}
	
	public static void init() throws IOException{
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		cow = new int[n];
		rental = new int[r];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			cow[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(shop.containsKey(b)) {
				shop.put(b, shop.get(b) + a);
			} else shop.put(b, a);
		}
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine());
			rental[i] = Integer.parseInt(st.nextToken());
		}
		/*
		int[] a = cow.clone(); Arrays.sort(a);
		for(int i = 0; i < a.length; i++) {
			cow[i] = a[a.length-i-1];
		}
		*/
		Arrays.sort(cow);
		Arrays.sort(rental);
		//System.out.println("rental: " + Arrays.toString(rental));
		//System.out.println(shop);
	}

	public static void solve() throws IOException{
		profit = new long[n];
		for(int i = 0; i < profit.length; i++) {
			profit[i] = money(cow[n - i - 1]);
			//result+=Math.max(profit[i], rental[i]);
		}
		//System.out.println("rental: " + Arrays.toString(rental));
		//System.out.println("profit: " + Arrays.toString(profit));
		for(int i = n-1, j = r-1; i >=0 && j >=0; i--, j--) {
		    profit[i] = Math.max(profit[i], rental[j]);
		}
		//System.out.println("rental: " + Arrays.toString(rental));
		//System.out.println("profit: " + Arrays.toString(profit));
		for(int i = 0; i < profit.length; i++) {
			result+=profit[i];
		}
		out.println(result);
		//System.out.println(result);
	}
	
	public static int money(int gal) {
		int total = 0;
		while(gal > 0 && !shop.isEmpty()) {
			int price = shop.lastKey();
			int num = shop.get(price);
			if(num == 0) {
				shop.remove(price);
				continue;
			}
			if(num > gal) {
				shop.put(price, num-gal);
				total += gal*price;
				gal = 0;
			}
			else {
				shop.put(price, 0);
				total += num*price;
				gal -= num;
			}
		}
		return total;
	}
}