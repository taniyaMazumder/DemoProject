package Recursion;

public class PowerSetStringRec {

	public static void main(String[] args) {
		String s = "abc";
		printPermuteRec(s);

	}
	static void printPermuteRec(String str) {
		printPowerSet("", str);
	}
	static void printPowerSet(String p, String up) {
		if(up.isEmpty()) {
			System.out.print(p);
			System.out.print(" ");
			return;
		}
		char ch = up.charAt(0);
		printPowerSet(p + ch, up.substring(1));
		printPowerSet(p , up.substring(1));
	}

}
