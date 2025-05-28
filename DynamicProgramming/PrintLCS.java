package DynamicProgramming;

import java.util.ArrayList;

public class PrintLCS {

	public static void main(String[] args) {
		String s1= "XMJYAUZ";
		String s2= "MZJAWXU";
		System.out.println(printLCS(s1,s2));

	}

	private static String printLCS(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] t = new int[n+1][m+1];
		// initialization of matrix t
				for (int i = 0; i < n+1; i++) {
					for (int j = 0; j < m+1; j++) {
						if( i==0 || j==0) {
							t[i][j] = 0;
						}
					}
				}
		// find LCS
				for(int i=1;i< n+1;i++) {
					for (int j = 1; j < m+1; j++) {
						if(str1.charAt(i -1) == str2.charAt(j -1)) {
							t[i][j] = 1+ t[i -1][j-1];
						}else {
							t[i][j] = Math.max(t[i-1][j], t[i][j-1]) ;
						}
					}
				}
				
		// code for print LCS
		int k =n; // row
		int l = m; // col
		
	//	ArrayList<String> al = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		
		while(k >0 && l >0) {
			if(str1.charAt(k -1) == str2.charAt(l -1)) {
				sb.append(String.valueOf(str1.charAt(k-1)));
			//	al.add(String.valueOf(str1.charAt(k-1)));
				k--;
				l--;
			} else {
				if(t[k][l-1] > t[k-1][l]) {
					l--;
				} else {
					k--;
				}
			}
		}
		String ans ="";
		// using stringbuilder
		ans = ans + sb.reverse().toString();
		// cz using arrayList
//		for(int i = al.size() -1; i>=0;i--) {
//			ans += al.get(i);
//		}
		return ans;	
	}

}
