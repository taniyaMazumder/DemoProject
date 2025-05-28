package array;

public class BeautifulMatrix1 {

	public static void main(String[] args) {
		int[][] mat = {
				{2,0,3,7},
				{1,4,1,3},
				{3,2,1,0},
				{6,2,1,4}
		
		};
		System.out.println(isBeauty(mat));

	}

	static boolean isBeauty(int[][] mat) {
		boolean flag = false;
//		for (int row = 0; row < mat.length; row++) {
//			int sum =0;
//			for (int col = 0; col < mat[row].length; col++) {
//				sum += mat[row][col];
//	            int rem = sum - mat[row][col];
//	            if(rem== mat[row][col]){
//	                flag=  true;
//	            }
//			}
//            
//			
//		}
		int row=0,col=0;
		while(row<mat.length-1) {
			int sum =0;
			while(col<mat[row].length-1) {
				sum += mat[row][col];
	            int rem = sum - mat[row][col];
	            if(rem== mat[row][col]){
	                flag=  true;
	                break;
	            }
	            row++;
			}
			col++;
		}
		return flag;
	}
}
