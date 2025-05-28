package Numbers;

public class Pattern {

	public static void main(String[] args) {
		pattern3(4);

	}
   static void pattern(int n) {
	   for(int row=1; row<=n;row++) {
		   // spaces
		   for(int s = 0;s< n-row;s++) {
			   System.out.print("  ");
		   }
		   for(int col =row; col>=1;col--) {
			   System.out.print(col +" ");
		   }
		   for(int col=2;col<=row;col++) {
			   System.out.print(col+" ");
		   }
		   System.out.println();
	   }
   }
   static void pattern2(int n) {
	   for (int row = 1; row <= 2* n ; row++) {
		   int totalNoOfCol = row > n ? 2* n -row : row;
		   for(int space= 0;space <n- totalNoOfCol;space++) {
			   System.out.print("  ");
		   }
		   for(int col =totalNoOfCol; col>=1;col--) {
			   System.out.print(col +" ");
		   }
		   for(int col=2;col<=totalNoOfCol;col++) {
			   System.out.print(col+" ");
		   }
		   System.out.println();
	}
   }
   
   static void pattern3(int n) {
	   int originalN =n;
	   n =  2* n;
	   for (int row = 0; row <= n ; row++) {
		   for (int col = 0; col <= n ; col++) {
			   int everyIndex = originalN - Math.min(Math.min(row, col), Math.min(n-row, n-col));
			   System.out.print(everyIndex + " ");
		   }
		   System.out.println();
	   }
   }
}
