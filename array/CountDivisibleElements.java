
// Let's take an array= {1,2,3,4,5}, find = sum=15;
// count the no of elements from the array which is used to divide the sum
package array;

public class CountDivisibleElements {

	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5};
		System.out.println(findCount(ar));
	}

	public static int findCount(int[] arr) {
		
		int sum =0;
		
		for(int i=0; i< arr.length; i++) {
			sum = sum + arr[i];
		}
		int count =0;
		for(int j=0; j< arr.length; j++) {
			if(sum % arr[j] ==0) {
				count++;
			}
		}
		return count;
	}
}
