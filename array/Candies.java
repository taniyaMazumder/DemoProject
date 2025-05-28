package array;

import java.util.ArrayList;
import java.util.List;

public class Candies {

	public static void main(String[] args) {
		int[] candies = {2,3,5,1,3};
	//	int[] candies = {4,2,1,1,2};
	//	int[] candies = {2,8,7};
		int extraCandies = 3;
		System.out.println(kidsWithCandies(candies,extraCandies));
	}

	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> list = new ArrayList<>();
		boolean flag = false;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < candies.length; i++) {
			
			if(max <= candies[i]) {
				max = candies[i];
			}
		}
		for (int j = 0; j < candies.length; j++) {
			int sum = candies[j] + extraCandies;
			
			if(max <= sum) {
				flag= true;
				list.add(flag);
				
			}
			else {
				flag = false;
				list.add(flag);
			}
			
		}
		return list;
	}
	
}
