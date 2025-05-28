package Recursion;

import java.util.ArrayList;

public class LinearSearchRec {

	public static void main(String[] args) {
		int[] arr = {4,12,67,40,40,99,50};
		int target = 40;
	//	System.out.println(searchRec(arr,0, target));
	//	System.out.println(searchAL(arr, target,0));
		ArrayList<Integer> ans = searchAL(arr, target,0);
		System.out.println(ans);
	}
 // return boolean
	static boolean searchRecBooleanRet(int[] arr,int index, int target) {
		if(index == arr.length) {
			return false;
		}
		return arr[index] == target  || searchRecBooleanRet(arr,index+1,target);
	}
	// return index value
	static int searchRec(int[] arr,int index, int target) {
		if(index == arr.length) {
			return -1;
		}
		return arr[index] == target ? index : searchRec(arr,index+1,target);
	}
	
	static ArrayList<Integer> searchAL(int[] ar, int target,int index){
		ArrayList<Integer> list = new ArrayList<>();
		if(index == ar.length) {
			return list;
		}
		if(ar[index] == target) {
			list.add(index);
		}
		ArrayList<Integer> list2= searchAL(ar, target,index+1);
		list2.addAll(list);
		return list2;
	}
	
	static ArrayList<Integer> searchRet(int[] ar, int target, int index, ArrayList<Integer> list){
		if(index == ar.length) {
			return list;
		}
		if(ar[index] == target) {
			list.add(index);
		}
		return searchRet(ar, target, index+1, list);
	}
}
