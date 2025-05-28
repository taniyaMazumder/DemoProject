package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BeginnerProgramming {

	public static void main(String[] args) {
	//	int[] ar = {2,3,4,8,2,5,3,3, 3,4,5,8,8,9};
		String s = "This is a string with whitespace. ";
		//	String s = "abcdrba";
		//	String[] ar= {"Jithin", "Arunima", "Akhil", "Matthew", "Benjamin"};
		//	findFreq(ar);
		//	printDup(ar);
		//	printArrayRev(ar);
		//	printLex(ar);
	//	System.out.println(findKLargest(ar,3));
	//	System.out.println(printStr(s));
	//	System.out.println(findCount(s));
     //   System.out.println(checkPalindrome(s));
		printLetter(s);
	}

	/*
	 * Q-1- Find the frequency of each elements in the array
	 */
	static HashMap<Integer, Integer> map = new HashMap<>();
	static void findFreq(int[] ar){
		int n = ar.length;
		
		for(int i=0;i<n;i++) {
			int ele = ar[i];
			if(map.containsKey(ele)) {
				map.put(ele, map.get(ele) +1);
			} else {
				map.put(ele, 1);
			}
		}
		// now print the values from map
		//Alternative method using entryset
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
	/*
	 * Print duplicate elements of an int array
	 */
	static void printDup(int[] ar) {
		int n = ar.length;
		for(int i=0;i<n;i++) {
			int ele = ar[i];
			if(map.containsKey(ele)) {
				map.put(ele, map.get(ele) +1);
			} else {
				map.put(ele, 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			 if(entry.getValue() !=1) {
				 System.out.print(entry.getKey() +" ");
			 }
		}
	}
	/*
	 * Sort the elements of an array in reverse order and print
	 */
	static void printArrayRev(int[] ar) {
		// to use collections method first we need to convert primitive to non-primitive data types array
		// and then can sort
		Integer[] list = Arrays.stream(ar).boxed().toArray(Integer[]::new);
		Arrays.sort(list, Collections.reverseOrder());
		for(Integer i: list) {
			System.out.print(i +" ");
		}
	}
	
	/*
	 * Sort string array in lexicographical order
	 */
	static void printLex(String[] str) {
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
	}
	/*
	 * Find kth smallest elements of an array
	 */
	static int findKSmallest(int[] ar, int k) {
		/* The below code will work if no duplicate elements are present in the array
		Arrays.sort(ar);
		return ar[k];
		*/
		// step-1: remove all the duplicate elements first
		// step-2: sort the array ascending order
		// step-3: find the kth smallest elements
		 HashSet<Integer> set = new HashSet<>();
		 for (int i = 0; i < ar.length; i++) {
			      set.add(ar[i]);
		}
		 // To sort set- first needs to convert from set to list
		 List<Integer> list = new ArrayList<>(set);
		 Collections.sort(list);
		 return list.get(k-1);
	}
	/*
	 * Find kth largest elements of an array
	 */
	static int findKLargest(int[] ar, int k) {
		
		// step-1: remove all the duplicate elements first
		// step-2: sort the array ascending order
		// step-3: find the kth smallest elements
		 HashSet<Integer> set = new HashSet<>();
		 for (int i = 0; i < ar.length; i++) {
			      set.add(ar[i]);
		}
		 List<Integer> list = new ArrayList<>(set);
		 Collections.sort(list, Collections.reverseOrder());
		 return list.get(k-1);
	}
	/*
	 * remove white spaces from string
	 */
	static String printStr(String s) {
		s= s.replaceAll("\\s", "");
		
		return s;
	}
	/*
	 * find the count the number of words in a string
	 */
	static int findCount(String s) {
		String[] arStr = s.split("\\s");
		return arStr.length;
	}
	/*
	 * check if a string is palindrome or not
	 */
	static boolean checkPalindrome(String s) {
		
		boolean flag = false;
		int i=0,j=s.length()-1;
		while(i<=j) {
			
			if(s.charAt(i) == s.charAt(j)) {
				flag = true;
				i++;
				j--;
				
			} else {
				flag = false;
				break;
			}
			
		}
		return flag;
	}
	/*
	 * Print first letter of each word in a string
	 */
	static void printLetter(String s) {
		String[] arStr = s.split("\\s");
		System.out.println(Arrays.toString(arStr));
		for (int i = 0; i < arStr.length; i++) {
			System.out.println(arStr[i].charAt(0));
		}
	}
}
