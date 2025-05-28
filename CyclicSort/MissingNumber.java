// here 0-n array
package CyclicSort;

public class MissingNumber {

	public static void main(String[] args) {
		int[] ar = {4,0,1,2};
		System.out.println(missingNumber2(ar));

	}
	public static int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            
            if(nums[i]< nums.length && nums[i] != nums[nums[i]]){
                // swap
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
       
        for(int j=0;j<nums.length;j++){
            if(nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }
     // swap
	static void swap(int[] nums, int f, int s){
            int temp = nums[f];
            nums[f] = nums[s];
            nums[s] = temp;
        }

	public static int missingNumber2(int[] nums) {
        int i=0;
        while(i<nums.length){
        	int correctIndex = nums[i] ;
			if(nums[i]< nums.length && nums[i] != nums[correctIndex]) {
                // swap
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
       
        for(int j=0;j<nums.length;j++){
            if(nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }
}
