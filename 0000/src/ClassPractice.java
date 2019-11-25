import java.util.Arrays;

public class ClassPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pair[] a = new pair[3];
		a[0] = new pair("Julia", 100);
		a[1] = new pair("Solomon", 100);
		a[2] = new pair("Eric", 97);
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

}

class pair implements Comparable<pair>{
	String name;
	int score;
	pair(String n, int s) {
		name = n;
		score = s;
	}
	public String toString() {
		return name + ": " + score;
	}
	@Override
	public int compareTo(pair that) {
		// TODO Auto-generated method stub
		
		if(this.score < that.score) return 1;
		else if (this.score > that.score) return -1;
		else {
			if(this.name.compareTo(that.name) > 0) return 1;
			else return -1;
		}
	}
}