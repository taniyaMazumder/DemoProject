package Recursion;

public class BinaryNumber1s0s {

	public static void main(String[] args) {
		NthBinary(3);
	}

	static void NthBinary(int n) {
		int one =0;
		int zero =0;
		String op="";
		solve(one,zero,n,op);
	}

	private static void solve(int one, int zero, int n, String op) {
		// Base Condition
		if(n == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		StringBuffer sb = new StringBuffer(op1);
		sb.append("1");
		solve(one +1, zero,n-1,sb.toString());
		
		if(one > zero) {
			String op2 = op;
			StringBuffer sb2 = new StringBuffer(op2);
			sb2.append("0");
			solve(one , zero +1,n-1,sb2.toString());
		}
		return;
	}
}
