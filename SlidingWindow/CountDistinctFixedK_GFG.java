// Count distinct elements in every window
package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctFixedK_GFG {

	public static void main(String[] args) {
//		int arr[] = {1, 2, 1, 3, 4, 2, 3};
//		int k = 4;
//		int arr[] = {4, 1, 1};
//		int k = 2;
		int arr[] = {1, 1, 1, 1, 1};
		int k = 3;
		System.out.println(countDistinct(arr,k));
	}

	static ArrayList<Integer> countDistinct(int arr[], int k) {
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		
		int i=0,j=0;
		
		
		while(j<arr.length) {
			
			int ele = arr[j];
			if(map.containsKey(ele)) {
				map.put(ele, map.get(ele) +1);
			} else {
				map.put(ele, 1);
			}
			int count = map.size();
			if(j-i+1 <k) {
				j++;
			}
			else if(j-i+1 == k) {
				list.add(count);
				
				// slide the window
				if(map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) -1);
					if(map.get(arr[i]) ==0) {
						map.remove(arr[i]);
						count--;
					}
					i++;
				}
				j++;
			}
		}
		return list;
		
    }
}
