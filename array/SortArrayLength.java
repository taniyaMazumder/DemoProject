/*
 * Given an array contains string- sort the array increasing order according to length of the strings
 */


package array;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayLength {

	public static void main(String[] args) {
		String[] str = {"Jithin", "Arunima", "Akhil", "Matthew", "Benjamin"};
		printArrSort2(str);

	}
	// TC- O(n^2)
   static void printArrSort(String[] str) {
	   int n = str.length;
	   
	   for (int i = 0; i < n; i++) {
		   for (int j = i+1; j< n; j++) {
			   if(str[i].length() > str[j].length()) {
				   String temp = str[i];
				   str[i] = str[j];
				   str[j] = temp;
			   }
		   }
		}
	   
	   System.out.print("Print the array: " +Arrays.toString(str));
	   System.out.println();
   }
   // TC-O(n)
   // Using comparator to solve this problem
   static void printArrSort2(String[] str) {
	   
	   Arrays.sort(str, new StringLengthComparator());
	   System.out.print("Print the array: " +Arrays.toString(str));
	   
   }

   
}
class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length() - o2.length();
	}
	   
   }
