package PracticeForInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recursion {

	public static void main(String[] args) {
	//	printAsc(5);
	//	System.out.println(fact(5));
	//	int n = 14;
//		reverse(n);
//		System.out.println(sum);
//		System.out.println(reverse(n));
	//	System.out.println(findPath(n));
		int[] arr= {1,2,3};
//		int target = 8;
//		System.out.println(rotatedBS(arr,target, 0, arr.length -1));
	//	bubbleSort(arr.length-1,0,arr);
//		selectionsort(arr,arr.length,0,0);
//		System.out.println(Arrays.toString(arr));
//		ArrayList<String> list = new ArrayList<>();
//		subsetIntRec(arr,0,list );
//		System.out.println(list);
//		System.out.println(subsetIntRecRet(arr));
//		System.out.println(subseqBodyListRet("abc",""));
	//	System.out.println(subset(arr));
	//	System.out.println(perm("abc",""));
		System.out.println(permutationCount("abc",""));
	}

	static void printDesc(int n) {
		if(n==1) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		printDesc(n-1);
	}
	static void printAsc(int n) {
		if(n==1) {
			System.out.println(n);
			return;
		}
		printAsc(n-1);
		System.out.println(n);
	}
	// find fact
	static int fact(int n) {
		if(n==1) {
			return 1;
		}
		if(n==0) return 0;
		return n* fact(n-1);
	}
	// sum of digits
	
	int sumRec(int num) {
		if(num ==0) return 0;
		
		return num %10 + sumRec(num/10);
	}
	// reverse a num using rec
	static int sum=0;
	static int reverse(int num) { // 1234 4321
		if(num ==0) return 0;
		int rev = num %10;
		sum = sum *10 + rev;
		reverse(num /10);
		return sum;
	}
	// palindrome
	static boolean isPalindrome(int num) {
		int revNum= reverse(num);
		return num == revNum;
	}
	// count zeros
	
	static int findZeros(int num) {
		return helper(num,0);
	}
	static int helper(int num, int count) {
		if(num ==0) return count;
		return ((num %10)==0) ? helper(num /10, count++) : helper(num /10, count);
	}
	// count path
	static int findPath(int num) {
		return helper2(num,0);
	}
	static int helper2(int num, int step) {
		if(num ==0) return step;
		return num %2==0 ? helper2(num /2, step+1) : helper2(num -1, step+1);
	}
	/*
	 * check if array is sorted using rec
	 */
	static boolean isSorted(int[] ar, int index) {
		if(index == ar.length -1) {
			return true;
		}
		return ar[index] < ar[index+1] && isSorted(ar,index+1);
	}
	// linear search rec
	static int linearSearch(int[] ar, int target, int index) {
		if(index == ar.length) {
			return -1;
		}
		return ar[index]== target ? index : linearSearch(ar, target, index+1);
	}
	// rotated BS
	static int rotatedBS(int[] ar, int target, int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = start +(end- start)/2;
		
		if(target == ar[mid] ) {
			return mid;
		}
		
		if(ar[start] <ar[mid]) {
			if(ar[start] <= target && target <= ar[mid]) {
				return rotatedBS(ar, target, start, mid-1);
			}else {
				return rotatedBS(ar, target, mid+1, end);
			}
		} else {
			if(ar[mid] <= target && target <= ar[end]) {
				return rotatedBS(ar, target, mid+1, end);
			} else {
				return rotatedBS(ar, target, start, mid-1);
			}
		}
	}
	/*
	 * Pattern *
	 */
	static void patternTriangle(int row, int col) {
		if(row ==0) {
			return;
		}
		if(col<row) {
			patternTriangle(row, col+1);
			System.out.print("*");
		} else {
			patternTriangle(row -1, 0);
			System.out.println();
		}
	}
	// bubble sort using rec
	static void bubbleSort(int row, int col, int[] ar) {
		if(row==0) return;
		if(col<row) {
			if(ar[col] >ar[col+1]) {
				int temp = ar[col];
				ar[col] = ar[col+1];
				ar[col+1] = temp;
			}
			bubbleSort(row,col+1,ar);
		} else {
			bubbleSort(row -1,0,ar);
		}
	}
	// selection sort using recursion
	static void selectionsort(int[] ar, int row, int col, int max) {
		if(row==0) {
			return;
		}
		if(col<row) {
			if(ar[col] > ar[max]) {
				selectionsort(ar, row,col+1,col);
			} else {
				selectionsort(ar, row,col+1,max);
			}
		} else {
			int temp = ar[max];
			ar[max] = ar[row-1];
			ar[row-1] = temp;
			
			selectionsort(ar, row-1,0,0);
		}
	}
	
	/*
	 * subset integer recursion
	 * 
	 */
	static void subsetIntRec(int[] ar, int index, List<Integer> list) {
		if(index== ar.length) {
			System.out.println(list);
			return ;
		}
		subsetIntRec(ar, index+1, list);
		list.add(ar[index]);
		
		subsetIntRec(ar, index+1, list);
		list.remove(list.size()-1);
		
	}
	
	// return as a list
	
	static List<List<Integer>> subsetIntRecRet(int[] ar) {
		List<List<Integer>> outer = new ArrayList<>();
		if(outer.size() ==0) {
			return outer;
		}
		List<Integer> internal = new ArrayList<>();
		helperRet(ar,0,internal,outer);
		return outer;
		
		
		
	}
	static void helperRet(int[] ar, int index, List<Integer> internal, List<List<Integer>> outer) {
		if(index== ar.length) {
			outer.add(new ArrayList<>(internal));
			
			return ;
		}
		internal.add(ar[index]);
		helperRet(ar, index+1, internal,outer);
		internal.remove(internal.size()-1);
		helperRet(ar, index+1, internal,outer);
		return;
		
	}
	// subsequence string 
	static void subseq(String up, String p) {
		if(up.length()==0) {
			System.out.println(p);
			return;
		}
		char c = up.charAt(0);
		
		subseq(up.substring(1),p);
		subseq(up.substring(1),p+c);
	}
	// ret a list
	static List<String> subseqRet(String up, String p,ArrayList<String> list) {
		if(up.length()==0) {
			return list;
		}
		char c = up.charAt(0);
		
		subseqRet(up.substring(1),p,list);
		subseqRet(up.substring(1),p+c,list);
		
		list.add(p+c);
		return list;
	}
	// do not ret list as arg
	static List<String> subseqBodyListRet(String up, String p) {
		
		if(up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		char c = up.charAt(0);
		
		List<String> left = subseqBodyListRet(up.substring(1), p);
		List<String> right = subseqBodyListRet(up.substring(1), p+c);
		
		left.addAll(right);
		
		return left;
	}
	// iterative way to find subset 
	static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> outer  =  new ArrayList<>();
		
		outer.add(new ArrayList<>());
		
		for(int num : arr) {
			int size = outer.size();
			 for(int i=0; i<size;i++) {
				 List<Integer> internal = new ArrayList<>(outer.get(i));
				 internal.add(num);
				 outer.add(internal);
			 }
			
		}
		return outer;
	}
	// remove duplicates by using rec
	static List<List<Integer>> remDup(int[] ar) {
		Arrays.sort(ar);
		Set<List<Integer>> set = new HashSet<>();
		helperSet(ar,0,new ArrayList<>(), set);
		return new ArrayList<>(set);
	}

	private static void helperSet(int[] ar, int index, ArrayList<Integer> internal, Set<List<Integer>> outer) {
		if(index == ar.length) {
			outer.add(new ArrayList<>(internal));
			return ;
		}
		internal.add(ar[index]);
		helperSet(ar, index+1, internal,outer);
		
		internal.remove(internal.size()-1);
		helperSet(ar, index+1, internal,outer);
	
	}
	/*
	 * Permutations
	 */
	static List<String> perm(String up, String p){
		if(up.isEmpty()) {
			List<String> str = new ArrayList<>();
			str.add(p);
			return str;
		}
		char ch = up.charAt(0);
		List<String> strList = new ArrayList<>();
		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			strList.addAll(perm(up.substring(1), first+ch+second));
		}
		return strList;
		
	}
	// count the no of perm
	static int findCountPerm() {
		List<String> strList = perm("abc","");
		return strList.size();
	}
	

	private static int permutationCount(String up, String p) {
		if(up.isEmpty()) {
			return 1;
		}
		char c = up.charAt(0);
		int count=0;
		for(int i =0; i<=p.length();i++) {
			String first =  p.substring(0,i);
			String second =  p.substring(i,p.length());
			count = count + permutationCount(up.substring(1),first + c+ second);
		}
		return count;
		
		
	}
}
