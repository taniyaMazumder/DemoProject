package PracticeForInterview;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
// Min no of deletions to make a string palindrome
	static int min(String s) {
		StringBuilder sb = new StringBuilder(s);
		String t = sb.reverse().toString();
		return helper(s,t,s.length(),t.length());
	}
  private static int helper(String s, String t, int slength, int tlength) {
	if(slength ==0 || tlength==0) {
		return 0;
	}
	if(s.charAt(slength-1) == t.charAt(tlength-1)) {
		return slength - (1+helper(s,t,slength-1,tlength-1));
	}
	return slength -(Math.max(helper(s,t,slength,tlength-1), helper(s,t,slength-1,tlength)));
}
  // palindrome partition
  static int palindrome(String s, int i, int j) {
	  if(i>j) {
		  return 0;
	  }
	  int ans=0;
	  if(isPalindrome(s,i,j)) {
		  return 0;
	  }
	  for(int k=i; k<j;k++) {
		  int temp = 1+ palindrome(s,i,k) + palindrome(s,k+1,j);
		  ans = Math.min(ans, temp);
	  }
	return ans;
  }
private static boolean isPalindrome(String s, int i, int j) {
	while(i<=j) {
		if(s.charAt(i) != s.charAt(j)){
			return false;
		}
		i++;
		j--;
	}
	return true;
}
}
