/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

package DynamicProgramming;

public class BuySellStockMaxProfitPartI {

	public static void main(String[] args) {
		int[] ar = {7,1,5,3,6,4};
		System.out.println(findMaxProftRec(ar));

	}

	static int findMaxProfit(int[] prices) {
		int min = prices[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			int cost = prices[i] - min;
			max = Math.max(max, cost);
			min = Math.min(min, prices[i]);
		}
		return max;
	}
	// using recursion TC-O(2^n) ,SC- O(n) for recursion
	static int findMaxProftRec(int[] prices) {
		return helper(prices,0,Integer.MAX_VALUE);
	}
	private static int helper(int[] prices, int index, int min) {
		// Base condition
		if(index == prices.length) {
			return 0;
		}
		int minEnd = Math.min(min, prices[index]);
		int maxProfit = helper(prices, index +1, minEnd) ;
		maxProfit= Math.max(maxProfit, prices[index] - min);
		return maxProfit;
	}
	
	
}
