package LinearSearch;

public class LinearSearchString {

	public static void main(String[] args) {
		String name= "Taniya";
		char target = 'm';
		System.out.println(linearSearch(name,target));
	}
	public static boolean linearSearch(String s, char target) {
	
		if(s.length() ==0) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char  ch = s.charAt(i);
			if(target == ch) {
				return true;
			}
		}
		return false;
	}
	

}
