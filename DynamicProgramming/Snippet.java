package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Snippet {
	public static void main(String[] args) {
	//	String a ="abdbbeghege";
//		String a ="repggxrpnr";
//		System.out.println(findMinimumDeletion(a));
		String s = "repggxrpnr";
        int n = s.length();
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++) 
            {
                dp[i][j] = -1;
            }
        }
        System.out.println(findMinimumDeletion(0, n - 1, dp, s));
	}
/*	public static int getOperations(String s) {
	Map<Character, Integer> map = new HashMap<>();
	        int count =0;
	        for(int i=0; i<s.length();i++) {
	            char ch = s.charAt(i);
	            if(map.containsKey(ch)) {
	                map.put(ch, map.get(ch) +1);
	                
	            } else {
	                map.put(ch,1);
	            }
	            if(map.get(ch) == 3){
                    count++;
                    map.remove(ch);
                }
	        }
	        return count;
	        
 }
 */
	// Java implementation of the approach
	
	    static int N = 10;

	    // Function to return the minimum number of
	    // delete operations
	    static int findMinimumDeletion(int l, int r, 
	                            int dp[][], String s)
	    {

	        if (l > r) 
	        {
	            return 0;
	        }
	        if (l == r) 
	        {
	            return 1;
	        }
	        if (dp[l][r] != -1) 
	        {
	            return dp[l][r];
	        }

	        // When a single character is deleted
	        int res = 1 + findMinimumDeletion(l + 1, r, dp, s);

	        // When a group of consecutive characters
	        // are deleted if any of them matches
	        for (int i = l + 1; i <= r; ++i)
	        {

	            // When both the characters are same then
	            // delete the letters in between them
	            if (s.charAt(l) == s.charAt(i)) 
	            {
	                res = Math.min(res, findMinimumDeletion(l + 1, i - 1, dp, s)
	                        + findMinimumDeletion(i, r, dp, s));
	            }
	        }

	        // Memoize
	        return dp[l][r] = res;
	    }

	    
	}

	// This code contributed by Rajput-Ji



