package DynamicProgramming;

public class FindCountTarget_VariableSLW_GFG {

	public static void main(String[] args) {
		int[] ar= {5, 2, 3, 10, 6, 8};
		int target=10;
		System.out.println(perfectSumBF(ar, target));

	}
  // brute force
	public static int perfectSumBF(int[] nums, int target) {
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			int sum =0;
			for (int j = 0; j < nums.length; j++) {
				sum = sum + nums[j];
				if(sum == target) {
					count++;
				}
			}
		}
		return count;
	}
	public static int perfectSum(int[] nums, int target) {
        int i=0,j=0,sum=0, count=0;
        
        while(j<nums.length){
            sum = sum + nums[j];
            
            if(sum < target) {
                j++;
            }
            else if(sum == target) {
                count++;
                j++;
            }
            else if(sum >target) {
            	while(sum >target) {
	                sum = sum - nums[i];
	                i++;
            	}
            	if(sum == target) {
                    count++;
            	}
	              j++;
            }
        }
        return count;
    }
}
