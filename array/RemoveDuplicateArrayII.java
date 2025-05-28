package array;

public class RemoveDuplicateArrayII {

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(arr));

	}
	public static int removeDuplicates(int[] nums) {
		int index= 1;
        int counter= 0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				counter++;
	        }
	        else {
	        	counter= 0;
	        	//nums[slow++] = nums[fast++];
	        }
		}
		return nums.length;
    }

}
