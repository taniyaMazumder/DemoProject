// Given two baskets and picked up fruites in 2 diff types
// it similar to Largest subarray K unique char variable slw
package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruiteIntoBaskets {

	public static void main(String[] args) {
	//	int[] ar = {1,2,3,2,2};
	//	int[] ar = {0,1,2,2};
		int[] ar = {1,2,1};
		System.out.println(totalFruit(ar));
	

	}
	public static int totalFruit(int[] fruits) {
		int k =2; // Given two types of fruits
		int i=0,j=0;
		Map<Integer,Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		while(j<fruits.length) {
			int ele = fruits[j];
			if(map.containsKey(ele)) {
				map.put(ele, map.get(ele) +1);
			}
			else {
				map.put(ele, 1);
			}
			int count = map.size();
			if(count < k) {
				j++;
			}
			else if(count == k) {
				max = Math.max(max, j -i +1);
				j++;
			}
			else if(count >k) {
				while(count >k) {
					int ele2 = fruits[i];
					  map.put(ele2, map.get(ele2) -1);
						if(map.get(ele2) ==0) {
							map.remove(ele2);
							count--;
						}
					
					i++;
				}
				j++;
			}
		}
		return max;
        
    }
}
