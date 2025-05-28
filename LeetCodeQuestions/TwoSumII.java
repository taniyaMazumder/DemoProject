package LeetCodeQuestions;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TwoSumII {

	public static void main(String[] args) {
		int[] numbers = {2,7,11,15};
		int target = 9;
//		int[] numbers = {2,3,4};
//		int target = 6;
	//	System.out.println(Arrays.toString(findTarget(numbers,target)));
//		System.out.println(Arrays.toString(twoSumIITwoPointer(numbers,target)));
		//System.out.println(uniqueSubsets(numbers,target));
	}
// brute force solution
	static int[] findTarget(int[] numbers, int target) {
		int[] ans = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+ 1; j < numbers.length; j++) {
				if(numbers[i] + numbers[j] == target) {
					ans[0] = i +1;
					ans[1] = j +1;
				}
			}
		}
		return ans;
	}
	// using hashmap - O(n) & space= o(n)
	public static int[] twoSumII(int[] numbers, int target) {
        int[] ar= new int[2];
			HashMap<Integer,Integer> map = new HashMap<>();
			for(int i =0; i< numbers.length;i++) {
                if(map.containsKey(target - numbers[i])) {
					ar[0]= map.get(target - numbers[i]);
					ar[1] =i +1;
					return ar;
				} else {
					map.put(numbers[i], i +1);
				}
			}
			return ar;
    }
	// using two pointer
	public static int[] twoSumIITwoPointer(int[] numbers, int target) {
		int start=0 , end = numbers.length -1;
		int[] ans= new int[2];
		while(start < end) {
			if(numbers[start] + numbers[end] == target) {
				ans[0] = start +1;
				ans[1] = end +1;
				return ans;
				
			} else if(numbers[start] + numbers[end] > target) {
				end--;
			}
			else if(numbers[start] + numbers[end] < target) {
				start++;
			}
		}
		return ans;
	}
}
	// using recursion
/*	static int[] findSubsetRec(int[] ar, int target) {
		int[] ans = new int[2];
		
		helper(ar,target, ar.length,ans);
		return ans;
	}
	private static void helper(int[] ar, int target, int n, int[] ans) {
		
		int start =0;
		if( n==0 && target>0) {
			ans[0] = 0;
			ans[1] =0;
			return;
		}
		if(n >0 && target ==0) {
			ans[0] = ar[start+1];
			ans[1] = ar[n-1];
			return;
		}
		if(ar[n-1] <= target) {
			helper(ar, target - ar[n-1],n-1,ans);
			helper(ar, target,n-1,ans);
			return;
		} else {
			helper(ar, target,n-1,ans);
			return ;
		}
		
	}
	
	
	public static void findUniqueSubsets(int[] arr, int index, List<Integer> internal, Set<List<Integer>> outer, int target) {
		// base condition
		if(index == arr.length -1) {
			outer.add(new ArrayList<>(internal));
			return;
		}
		if(index <arr.length && arr[index] + arr[index+1] == target) {
			// include the current element
			internal.add(arr[index]);
		}
		
		findUniqueSubsets(arr, index +1, internal, outer,target);
		
		// exclude the current element
		// backtrack
		internal.remove(internal.size() -1);
		findUniqueSubsets(arr, index +1, internal, outer,target);
		 return;
	}
	
	public static List<List<Integer>> uniqueSubsets(int[] arr, int target) {
		// sort the array first to get the duplicate elements to be adjacent
		Arrays.sort(arr);
		Set<List<Integer>> list = new HashSet<>();
		
		findUniqueSubsets(arr,0,new ArrayList<>(), list,target);
		return new ArrayList<>(list);
	}
	*/
	// using recursion
	/*	class Pair<k, l> {
	    public k key;
	    public l value;

	    public Pair(k key, l value) {
	        this.key = key;
	        this.value = value;
	    }
	}
static List<Integer> findTargetSubsetTopDown(int[] arr, int sum) {
		
		return helper(arr, sum, arr.length -1);
	}
	public static List<Integer> helper(int[] arr, int sum, int n) {
		boolean[][] t = new boolean[arr.length +1][sum +1];
		
		//initialization true and false
        for(int i = 0; i<sum+1; i++)
        {
        	t[0][i] = false;
        }
        
        for(int i = 0; i<n+1; i++)
        {
        	t[i][0] = true;
        }
        
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1] <=j) {
					t[i][j] = t[i-1] [j - arr[i-1]] ||  t[i-1][j];
				}else  {
					t[i][j] = t[i-1][j];
				} 
			}
		}
		// code for print LCS
				int k =n; // row
				int l = sum; // col
				
				ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
				deque.add(new Pair(arr.length, target, ""));
				while(deque.size() >0) {
					Pair rem = deque.removeFirst();
					if(rem.key ==0 && rem.value == 0) {
						
					}
					if(t[k][l] == true) {
						list.add(arr[k]);
						k--;
						l--;
					}
				}
				
		return list;
	} 
		
}
*/
