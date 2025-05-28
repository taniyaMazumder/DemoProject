package DynamicProgramming;

public class MinNoOfInsertionToMakePalindrome {

	public static void main(String[] args) {
		String a ="aebcbda";
		System.out.println(minInsertion(a));

	}

	// find length of LCS
			static int minInsertion(String a) {
				StringBuffer sb = new StringBuffer(a);
				
				String b = sb.reverse().toString();
				
				int n = a.length();
				int m = b.length();
				
				int[][] t = new int[n +1][m+1];
				//initialize 0th row, 0th col
				
				for (int i = 0; i < n +1; i++) {
					for(int j=0; j < m+1; j++) {
						if(i ==0 || j ==0) {
							t[i][j] = 0;
						}
					}
				}
				
				//logic for 1st row
				for (int i = 1; i < n +1; i++) {
					for(int j=1; j < m+1; j++) {
						if(a.charAt(i -1) == b.charAt(j -1)) {
							t[i][j] = 1+ t[i-1][j-1];  
						} else {
							t[i][j] = Math.max(t[i][j-1], t[i -1][j]) ;
						}
					}
				}
				// Min no of deletion = min No of Insertion
				return n-t[n][m]; // while Question is for Min No of deletion 
				// no of insertion = no of deletion
			}
}
