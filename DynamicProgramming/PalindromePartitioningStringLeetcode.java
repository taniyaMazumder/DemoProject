// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningStringLeetcode {

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));

	}
	public static List<List<String>> partition(String s) {

	result=new ArrayList<>();
    partitionHelper(s,new ArrayList<>());
    return result;
}
private static List<List<String>> result;

private static boolean isPalindrome(String str){
    int low=0 , high=str.length()-1;
    
    while(low<high){
        if(str.charAt(low)!=str.charAt(high)) return false;
        low++;
        high--;
    }
    return true;
}

private static void partitionHelper(String ques,List<String> ans){
    if(ques.length()==0){
        result.add(new ArrayList<>(ans));
        return;
    }
    
    for(int i=0;i<ques.length();i++){
        String prefix=ques.substring(0,i+1);
        if(isPalindrome(prefix)){
            String ros=ques.substring(i+1); //ros: rest of string
            ans.add(prefix);
            partitionHelper(ros,ans);
            ans.remove(ans.size()-1);
        }
    }
}
}
