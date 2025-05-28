package Recursion;

public class PermutationWithCaseChange {

	public static void main(String[] args) {
		String ip ="ab";
		String op = "";
		check(ip,op);
		System.out.println();

	}

	static void check(String ip,String op)
    {
        if(ip.length()==0)
        {
            System.out.println(op);
            return;
        }
        String op1=op;
        String op2=op;
        op1=op1+ip.charAt(0);
       op2=op2+Character.toUpperCase(ip.charAt(0));

        ip=ip.substring(1);
        check(ip,op1);
        check(ip,op2);
    }
}
