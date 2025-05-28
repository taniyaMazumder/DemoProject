// between two lists, find common string and then return the string of which is least index sum
package array;

public class CommonString {

	public static void main(String[] args) {
		String[] list1 = {"happy","sad","good"};
		String[] list2 = {"sad","happy","good"};
		
		System.out.println(findRestaurant(list1, list2));

	}

	public static String[] findRestaurant(String[] list1, String[] list2) {
		String[] s = new String[2];
		int minIndex =Integer.MAX_VALUE;
		int sum =0;
        for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list2.length; j++) {
				if(list1[i] == list2[j]) {
					sum = sum + (i + j);
					if(sum < minIndex) {
						minIndex = sum;
					}
					
				}
			}
			s[i] = "minIndex";
		}
        
        
        return s;
    }
}
