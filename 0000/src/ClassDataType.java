import java.util.*;
import java.io.*;

public class ClassDataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		triple[] a = new triple[4]; 
		a[0] = new triple(1, 2, 3);
		a[1] = new triple(1, 3, 7);
		a[2] = new triple(4, 3, 6);
		a[3] = new triple(5, 9, 2);
		
		for(int i = 0; i < 4; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		Arrays.sort(a);
		
		for(int i = 0; i < 4; i++) {
			System.out.println(a[i]);
		}
	}
	
	static class triple implements Comparable<triple> {
		int x;
		int y;
		int z;
		
		triple(int inputx, int inputy, int inputz) {
			x = inputx;
			y = inputy;
			z = inputz;
		}
		
		public String toString() {
			return x + " " + y + " " + z;
		}
		
		@Override
		public int compareTo(triple that) {
			if(that.y - this.y < 0) return -1;
			//else if(that.y - this.y > 0) return 1;
			else {
				if(this.x - that.x < 0) return -1;
				else return 1;
			}
		}
	}

}
