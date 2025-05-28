package DynamicProgramming;
import java.util.ArrayList;
import java.util.List;
public class partition {
	

	public static void main(String[] args) {
        int[] nums = {2, 2, 4};
     //   List<List<Integer>> partitions = partitionWithEqualProduct(nums);
        System.out.println(isSubsetSum(nums,nums.length,1));
    }
/*
	    public static List<List<Integer>> partitionWithEqualProduct(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (nums == null || nums.length < 2) {
	            return result;
	        }

	        backtrack(nums, 0, new ArrayList<>(), new ArrayList<>(), result);
	        return result;
	    }

	    private static void backtrack(int[] nums, int index, List<Integer> set1, List<Integer> set2, List<List<Integer>> result) {
	        if (index == nums.length) {
	            if (getProduct(set1) == getProduct(set2)) {
	                result.add(new ArrayList<>(set1));
	                result.add(new ArrayList<>(set2));
	            }
	            return;
	        }

	        set1.add(nums[index]);
	        backtrack(nums, index + 1, set1, set2, result);
	        set1.remove(set1.size() - 1);

	        set2.add(nums[index]);
	        backtrack(nums, index + 1, set1, set2, result);
	        set2.remove(set2.size() - 1);
	    }

	    private static int getProduct(List<Integer> set) {
	        int product = 1;
	        for (int num : set) {
	            product *= num;
	        }
	        return product;
	    }
*/
	    static int isSubsetSum(int[] arr, int n, int prod) {
	    	if(prod != 0) {
	            return 1;
	        }
	        if(n==0){
	            return 0;
	        }

	        // If last element is greater than sum, then ignore it
	        if (arr[n - 1] > prod)
	            return isSubsetSum(arr, n - 1, prod);

	        // Check if sum can be obtained by any of the following
	        // (a) including the last element
	        // (b) excluding the last element
	        int left = isSubsetSum(arr, n - 1, prod) ;
	         
	        int right =       isSubsetSum(arr, n - 1, prod / arr[n - 1]);
	        int count =0;
	        if(left == right) {
	        	count ++;
	        }
	        return count;
	    }

	    // Returns true if arr[] can be partitioned in two
	    // subsets of equal sum, otherwise false
	    static int findPartition(int[] arr) {
	      
	        // Calculate sum of the elements in array
	        int prod = 1;
	        for (int num : arr) {
	            prod *= num;
	        }

	        // If sum is odd, there cannot be two 
	        // subsets with equal sum
	        if (prod % 2 != 0)
	            return 0;

	        // Find if there is subset with sum equal 
	        //to half of total sum
	        return isSubsetSum(arr, arr.length, prod / 2);
	    }
	    
	}

