
public class SieveOfErastosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void findPrimes() {
		int sqrt = (int) Math.sqrt(MAX);
		for(int i = 2; i <= sqrt; i++) {
			if(isPrime[i]) continue;
			for(int j = i + i; j <= MAX; j+=i) {
				isPrime[j] = true;
			}
		}
	}
	
	public static void setPrimes() {
		temp = 0;
		for(int i = 2; i <= MAX; i++) {
			if(!isPrime[i]) primes[temp++] = i;
		}
	}

}
