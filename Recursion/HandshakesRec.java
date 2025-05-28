package Recursion;

public class HandshakesRec {

	public static void main(String[] args) {
		int n = 4;
		handshakePrint(n);

	}

	static void handshakePrint(int n) {
		helper("","1234");
		
	}

	private static void helper(String p, String up) {
		if(up.isEmpty()) {
			if( !p.isEmpty() && p.length() >1) {
				System.out.print(p + " ");
				return;
			}
			return;
		}
		char c = up.charAt(0);
		helper(p,up.substring(1));
		helper(p +c, up.substring(1));
	}
}
