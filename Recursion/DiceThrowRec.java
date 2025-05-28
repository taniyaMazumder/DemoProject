// You are given a dice and target. Find how many ways we can find the target
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceThrowRec {

	public static void main(String[] args) {
//		int[] dice = {1,2,3,4,5,6};
		int target =4;
//		findTarget("", target);
		System.out.println(findTargetRet("", target));

	}

	static void findTarget(String p , int target) {
		// base condition
				if(target ==0) {
					System.out.println(p);
					return;
				}
				for(int i=1; i<6 && i <= target;i++) {
					findTarget( p +i, target -i);
				}
	}
	// returning as a list
	static List<String> findTargetRet(String p , int target) {
		// base condition
				if(target ==0) {
					List<String> list = new ArrayList<>();
					list.add(p);
					return list;
				}
				List<String> temp = new ArrayList<>();
				for(int i=1; i<6 && i <= target;i++) {
					 temp.addAll(findTargetRet( p +i, target -i));
				}
				return temp;
	}
	// dice face for 6 or 8 face
	// returning as a list
		static List<String> findTargetDiceFaceRet(String p , int target, int face) {
			// base condition
					if(target ==0) {
						List<String> list = new ArrayList<>();
						list.add(p);
						return list;
					}
					List<String> temp = new ArrayList<>();
					for(int i=1; i<=face && i <= target;i++) {
						 temp.addAll(findTargetDiceFaceRet( p +i, target -i,face));
					}
					return temp;
		}

}
