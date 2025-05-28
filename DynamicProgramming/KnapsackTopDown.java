// iterative approach

package DynamicProgramming;

public class KnapsackTopDown {

	public static void main(String[] args) {
//		int[] wt = {1,3,4,5};
//		int[] val = {1,4,5,7};
//		int w = 7;
		int[] wt = {4, 5, 1};
		int[] val = {1, 2, 3};
		int w = 4;
		System.out.println(knapsackTopDown(wt, val,w,wt.length ));

	}
	public static int knapsackTopDown(int[] wt, int[] val, int W, int n) {
		int t[][] = new int[n+1][W+1];

        //initilizing the 0th indexes
        for(int i =0; i<n+1; i++)
        {
            for(int j = 0; j<W+1; j++)
            {
                if(i == 0 || j == 0)
                {
                    t[i][j] = 0;
                }
            }
        }

        for(int i =1; i<n+1; i++) // replace n with i and W with j
        {
            for(int j = 1; j<W+1; j++)
            {
                if(wt[i-1] <= j)
                {
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][W];
	}
}
