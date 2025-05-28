package DynamicProgramming;

public class PalindromePartitioningRecursion {

	public static void main(String[] args) {
		String s = "nitik";
		System.out.println(findPartition(s,0,s.length()-1));

	}

	static int findPartition(String s, int i, int j) {
		// Base condition
		if(i >= j) {
			return 0;
		}
		if(isPalindrome(s,i,j) == true) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for(int k=i; k <=j-1;k++) {
			int temp = 1+ findPartition(s,i,k) + findPartition(s,k+1,j);
			ans= Math.min(ans, temp);
		}
		return ans;
	}

	public static boolean isPalindrome(String s, int i, int j) {
		while(i<=j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
	}
}
