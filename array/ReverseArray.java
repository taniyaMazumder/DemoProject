package array;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = {9,15,7,20,3};
		System.out.println(Arrays.toString(arr));
		
		//Loop through the array in reverse order  
        for (int i = arr.length-1; i >= 0; i--) {  
            System.out.print(arr[i] + " ");  
        }  
		//System.out.println(Arrays.toString(arr));

	}

}
