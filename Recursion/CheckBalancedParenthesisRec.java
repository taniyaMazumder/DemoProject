// return true or false to check if the expression with parenthesis is balanced or not
package Recursion;

import java.util.Arrays;

public class CheckBalancedParenthesisRec {

	public static void main(String[] args) {
		char[] exp = "[()]{}{[()()]()}".toCharArray(); // toCharArray is used to convert string to char
		int n = exp.length;
		if(check(exp,n) == true) {
			System.out.println("String is balanced");
		}
		else {
			System.out.println("String is NOT balanced");
		}
	}
	static char findClosing(char ch) {
		 
		if(ch == '(') {
			return ')';
		}
		if(ch == '{') {
			return '}';
		}
		if(ch == '[') {
			return ']';
		}
		return Character.MIN_VALUE;
	}
	static boolean check(char[] expr, int n) {
		if (n == 0)
            return true;
        if (n == 1)
            return false;
        if (expr[0] == ')' || expr[0] == '}' || expr[0] == ']')
            return false;
 
        // Search for closing bracket for first
        // opening bracket.
        char closing = findClosing(expr[0]);
 
        // count is used to handle cases like
        // "((()))". We basically need to
        // consider matching closing bracket.
        int i, count = 0;
        for (i = 1; i < n; i++) {
            if (expr[i] == expr[0])
                count++;
            if (expr[i] == closing) {
                if (count == 0)
                    break;
                count--;
            }
        }
 
        // If we did not find a closing
        // bracket
        if (i == n)
            return false;
 
        // If closing bracket was next
        // to open
        if (i == 1)
            return check(Arrays.copyOfRange(expr, i + 1, n), n - 2);
        // If closing bracket was somewhere
        // in middle.
          // check in the middle part and check in the remaining part
        return check(Arrays.copyOfRange(expr, 1, i), i - 1) && check(Arrays.copyOfRange(expr, (i + 1), n), n - i - 1);
    }

		
	}


