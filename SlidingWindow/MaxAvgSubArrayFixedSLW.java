package SlidingWindow;

public class MaxAvgSubArrayFixedSLW {

	public static void main(String[] args) {
//		int[] nums= {1,12,-5,-6,50,3};
//		int k=4;
		int[] nums= {5};
		int k=1;
		System.out.println(findMaxAverage(nums,k));

	}

	public static double findMaxAverage(int[] nums, int k) {
        int i=0, j=0;
        double max = -Double.MAX_VALUE; // if we can take -Double.MIN_VALUE then it will fail the condition where nums[]={-1} , k=1;
        								// avg is 1.00000 , not -0.00000
        double sum =0.00000;
        double avg =0.00000;
        
        while(j < nums.length) {
        	// calculation
        	sum = sum + nums[j];
        	        	
        	if(j-i+1 <k) {
        		j++;
        	}
        	else if(j - i +1 == k) {
        		// calculation
        		avg = sum / k;
        		max = Math.max(max, avg);
            	
        		// slide the window
        		sum = sum - nums[i];
        		i++;
        		j++;
        	}
        }
        return max;
    }
}
