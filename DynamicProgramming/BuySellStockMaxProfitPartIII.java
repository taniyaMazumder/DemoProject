package DynamicProgramming;

import java.util.Arrays;

public class BuySellStockMaxProfitPartIII {

	public static void main(String[] args) {
		int[] ar = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfitMemoization(ar));

	}
	public static int maxProfitRec(int[] prices) {
		int cap=2;
        return helper(prices, 0, 1, cap);
    }
	private static int helper(int[] prices, int index, int buy, int cap) {
		if(index == prices.length) {
			return 0;
		}
		if(cap ==0) {
			return 0;
		}
		int profit=0;
		if(buy==1) {
			profit = Math.max(-prices[index] + helper(prices, index +1, 0,cap), helper(prices, index +1, 1,cap));
		}
		else {
			profit = Math.max(prices[index] + helper(prices, index +1, 1,cap-1), helper(prices, index +1, 0,cap));
		}
		return profit;
	}
	// memoization
	static int[][][] t;
	public static int maxProfitMemoization(int[] prices) {
		int cap=2;
		int buy=1;
		int index =0;
		t = new int[index+1][buy+1][cap +1];
		for (int i = 0; i < t.length -1; i++) {
            for (int j = 0; j < t.length -1; j++) {
                for (int k = 0; k < t.length -1; k++) {
                    t[i][j][k] = -1;
                }
            }
        }
        return helper2(prices, 0, 1, cap,t);
    }
	private static int helper2(int[] prices, int index, int buy, int cap, int[][][] t) {
		if(index == prices.length) {
			return 0;
		}
		if(cap ==0) {
			return 0;
		}
		if(t[index][buy][cap] != -1) {
			return t[index][buy][cap];
		}
		int profit=0;
		if(buy==1) {
			profit = Math.max(-prices[index] + helper2(prices, index +1, 0,cap,t), helper2(prices, index +1, 1,cap,t));
		}
		else {
			profit = Math.max(prices[index] + helper2(prices, index +1, 1,cap-1,t), helper2(prices, index +1, 0,cap,t));
		}
		return t[index][buy][cap] = profit;
	}
}
