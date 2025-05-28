package Numbers;

public class PrimeNumber {

	public static void main(String[] args) {
		int a= 23;

		System.out.println(isPrime(a));
	}
	
	public static boolean isPrime(int n) {
		
		if(n <=1) {
			return false;
		}
		int c= 2;
		while(c* c <= n) {
			if(n % c==0) {
				return false;
			}
			c++;
		}
		return true;
	}

}
