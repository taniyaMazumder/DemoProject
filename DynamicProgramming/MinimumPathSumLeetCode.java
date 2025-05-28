// Given mXn matrix and find minimum path sum .
package DynamicProgramming;

public class MinimumPathSumLeetCode {

	public static void main(String[] args) {
		int[][] grid={
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		  System.out.println(minPathSum(grid));
      // 	minPathSum(grid);
	}
 // using recursion
	public static int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		    return helper(grid,n-1,m-1);
//		helper2(grid,0,0,"");
		
    }
//	static int min = Integer.MAX_VALUE;
	static int up  =Integer.MAX_VALUE ,  left =Integer.MAX_VALUE;
private static int helper(int[][] grid, int row, int col) {
	// Base condition
	if(row == 0 && col == 0) {
		
		return grid[row][col];
	}
//	if(row <0 || col <0) {
//		return Integer.MAX_VALUE/10;
//	}
	//sum = sum + grid[row][col];
		
//	if(row < grid.length-1) {
//		 down =	grid[row][col] + helper(grid,row +1,col);
//	}
//	if(col < grid[0].length -1) {
//		right =grid[row][col] + helper(grid,row, col +1);
//	}
//	if(row < grid.length-1) {
	if(row >=1) {
		up =	grid[row][col] + helper(grid,row -1,col);
	}
	if(col >=1) {
		left =  grid[row][col] + helper(grid,row, col -1);
	}
//	}
//	if(col < grid[0].length -1) {
		
//	}
	return Math.min(up, left);
	
	}
// print min sum path
/*static int sum =0; 
private static void helper2(int[][] grid, int row, int col,String p) {
	// Base condition
	if(row == grid.length-1 && col == grid[0].length -1) {
		if(max < sum) {
			max = sum;
		}
		System.out.println(p);
		return ;
	}
//	sum=0;
	sum = sum + grid[row][col];
	
	if(row < grid.length-1) {
		helper2(grid,row +1,col,p + 'D');
//		int down = helper2(grid,row +1,col,p + 'D');
	}
	if(col < grid[0].length -1) {
		helper2(grid,row, col +1,p + 'R');
		//		int right =helper2(grid,row, col +1,p + 'R');
	}
	
	return ;
	
	}
	*/
}
