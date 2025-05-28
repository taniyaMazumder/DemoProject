// Given an array and windows size K . Find First neg no amongst each sub array of size k.
// Ex- if k =3 , then find First neg no when window size is 3.

package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindFirstNegNoSubArray {

	public static void main(String[] args) {
		int[] arr = {12,-1,15,-8,-4,65,-48,36,78,56};
		System.out.println(firstNegNo(arr,3));
	}

	static List<Integer> firstNegNo(int[] arr, int k) {
		
		int i= 0;
		int j=0;
		
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		while(j < arr.length) {
			if(arr[j] < 0) {
				queue.offer(arr[j]);
				
			}
			if((j - i +1) < k) {
				j++;
			}
			else if((j -i +1) == k) {
				if(queue.size() == 0) {
					list.add(0);
				}
				else {
					list.add(queue.peek());
					if(arr[i] == queue.peek()) {
						queue.poll();
					}
				}
						i++;
						j++;
			}
	}
		return list;
	}
}
