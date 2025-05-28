package LinearSearch;

import java.util.ArrayList;
import java.util.List;

public class FindNotDisappear {

	public static void main(String[] args) {
		int[] ar = {4,0,2,1};
		System.out.println(findDisappearedNumbers(ar));

	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		
		for (int index = 0; index < nums.length; index++) {
			if(nums[index] != index+1) {
				list.add(index+1);
			}
		}
		return list;
	}

}
