package Recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

	public static void main(String[] args) {
		System.out.println(josesphus(5,2));

	}

	static int  josesphus(int n, int k) {
		List<Integer> list = new ArrayList<>();
		
		for(int i=1; i<n; i++) {
			list.add(i);
		}
		k = k-1;
		int ans = -1;
		solve(k,0,list, ans);
		return list.get(0);
	}

	private static void solve(int k, int index, List<Integer> list, int ans) {
		// base condition
		if(list.size() == 1) {
			ans = list.get(0);
			return;
		}
		index = (index +k) % list.size();
		list.remove(index);
		solve(k,index,list,ans);
		return;
	}
}
