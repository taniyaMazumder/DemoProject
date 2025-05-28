package Numbers;

public class SumOfSquareOfDigits {

	public static void main(String[] args) {
		int num=123;
		System.out.println(findSquare(num));

	}

	static int findSquare(int num) {
		int sum =0;
		while(num >0) {
			int digit = num %10;
			sum = sum + digit * digit;
			num = num /10;
		}
		return sum;
	}
}
