package LinkedList;


public class BinaryToDecimalLL {

	//static ListNode head;
	public static void main(String[] args) {
		
//		int n=6;
//		int ans =0;
//		int base = 2;
//		while(n >0) {
//			// identify last digit of binary no
//			int lastDigit = n & 1;
//			n = n >> 1;
//			ans += lastDigit * base;
//			base = base *2;
//		}
//		System.out.println(ans);
		
		int n =101;
		int ans =0;
		
		while(n>0) {
			ans = ans << 1 |n ;
		}
		System.out.println(ans);
	}
	

//	static int convertDecimal(int n) {
//	
//		int ans =0;
//		int base = 2;
//		while(n >0) {
//			// identify last digit of binary no
//			int lastDigit = n & 1;
//			n = n >> 1;
//			ans += lastDigit * base;
//			base = base *2;
//		}
//		return ans;
//	}
	
}
