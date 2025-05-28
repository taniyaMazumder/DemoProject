package DynamicProgramming;

public class EggDroppingRecursion {

	public static void main(String[] args) {
		System.out.println(superEggDrop(3,5));

	}

	public static int superEggDrop(int e, int f) {
		// Base condition
		if(f == 0 || f==1) {
			return f;
		}
		if(e==1) {
			return f;
		}
		int mn = Integer.MAX_VALUE;
		
		for(int k=1; k<=f;k++) {
			int temp = 1+ Math.max(superEggDrop(e-1, k-1), superEggDrop(e, f-k));
			
			mn = Math.min(mn, temp);
		}
		return mn;
	}
}
