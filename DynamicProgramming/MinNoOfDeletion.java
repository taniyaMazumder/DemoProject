package DynamicProgramming;

public class MinNoOfDeletion {

	public static void main(String[] args) {
		String a ="abdbbeghege";
		System.out.println(minDeletion(a));

	}

	// find length of LCS
		static int minDeletion(String a) {
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
		//	return n- (n-t[n][m]); // while Question is for Max No of deletion 
			return n-t[n][m]; // while Question is for Min No of deletion 
		}
}
