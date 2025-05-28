package PracticeForInterview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SlidingWindow {

	public static void main(String[] args) {
		int[] ar = {1,2,4,5,3,9,7,6,5,4};
		System.out.println(maxSum(ar,3));

	}

	// max sum sub array of size k- fixed window
	static int maxSum(int[] ar, int k) {
		int i=0,j=0,sum=0;
		int maxSum=Integer.MIN_VALUE;
		
		while(j<ar.length) {
			sum+= ar[j];
			
			if(j-i+1 <k) {
				j++;
			}
			else if(j-i+1==k) {
				maxSum = Math.max(maxSum, sum);
				sum = sum - ar[i];
				i++;
				j++;
			}
		}
		return maxSum;
	}
	// First neg nos
	static List<Integer> firstNeg(int[] ar, int k) {
	int i= 0;
	int j=0;
	
	Queue<Integer> q = new LinkedList<>();
	List<Integer> list = new ArrayList<>();
	while(j<ar.length) {
		 if(ar[j]<0) {
			 list.add(ar[j]);
		 }
		   if(j-i+1<k) {
			   j++;
		   }
		   else if(j-i+1 ==k) {
			   if(q.size() ==0) {
				   list.add(0);
			   }
			   else {
				   list.add(q.peek());
				   if(ar[i] == q.peek()) {
					   q.poll();
				   }
				   i++;
				   j++;
			   }
		   }
	   }
	return list;
	}
	// count occurrences of anagrams
	static int findCount(String s, String t) {
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i=0;i<t.length();i++) {
			char ch = t.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		
		int size = map.size();
		int i=0,j=0,k=0;
		int ans=0;
		while(j<s.length()) {
			char ch2= s.charAt(j);
			if(map.containsKey(ch2)) {
				map.put(ch2, map.get(ch2)-1);
				if(map.get(ch2) ==0) {
					size--;
				}
			}
			if(j-i+1<k) {
				j++;
			}
			else if(j-i+1==k) {
				if(size==0) {
					ans++;
				}
				char ch3= s.charAt(i);
				if(map.containsKey(ch3)) {
					map.put(ch2, map.get(ch2)+1);
					if(map.get(ch2) ==1) {
						size++;
					}
				}
				i++;
				j++;
			}
		}
		
		return ans;
	}
	/*
	 * Max of all max sub array
	 */
	static List<Integer> max(int[] ar, int k){
		List<Integer> res = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();
		int i=0,j=0;
		
		while(j<ar.length) { // 1 3 2
			if(dq.size() ==0) {
				dq.add(ar[j]);
			}
			while(dq.size()>0 && dq.peekLast()<ar[j]) {
				dq.removeLast();
			}
			if(j-i+1 <k) {
				j++;
			}
			else if(j-i+1 ==k) {
				res.add(dq.peekFirst()); 
				// sliding
				if(dq.peekFirst() == ar[i]) {
					dq.removeFirst();
				}
				i++;
				j++;
			}
		}
	   return res;
	}
	/*
	 * print largest subarray max sum sub array BF
	 */
	static List<Integer> largestWindow(int[] ar, int k){
		int maxSum= Integer.MIN_VALUE;
		int prevMax=0,start=0,end=0;
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			int sum=0;
			for (int j = i; j < ar.length; j++) {
				sum += ar[j];
				if(sum ==k) {
					maxSum = Math.max(prevMax, j-i+1);
					if(maxSum > prevMax) {
						 start=i;
						 end=j;
					}
					prevMax =maxSum;
				}
			}
		}
		for (int m = start; m <=end; m++) {
			res.add(ar[m]);
		}
		return res;
	}
	// max subarray variable 
	static int variable(int[] ar, int k) {
		int i=0,j=0,maxSum=0,sum=0;
		while(j<ar.length) {
			sum += ar[j];
			if(sum <k) {
				j++;
			}
			else if(sum ==k) {
				maxSum = Math.max(maxSum, j-i+1);
				j++;
			}
			else if(sum>k) {
				while(sum>k) {
					sum = sum- ar[i];
					i++;
					
				}
				j++;
			}
		}
		return maxSum;
		
	}
	// k uniq char
	static int findMaxLengthSubString(String s, int k) {
		int i=0,j=0;
		int max = Integer.MIN_VALUE;
		Map<Character,Integer> map = new HashMap<>();
		
		while(j < s.length()) {
			  char c = s.charAt(j);
			  if(map.containsKey(c)) {
				  map.put(c, map.get(c)+1);
			  } else {
				  map.put(c, 1);
			  }
			  int count = map.size();
			   
			  if(count <k) {
				  j++;
			  }
			  else if(count==k) {
				  max = Math.max(max, j-i+1);
				  j++;
			  }
			  else if(count>k) {
				  while(count >k) {
					  if(map.containsKey(c)) {
						  map.put(c, map.get(c)-1);
						  if(map.get(c)==0) {
							  map.remove(c);
						  }
					}
					  i++;
				  }
				  j++;
			  }
			}
		return max;
	}
	/*
	 * Min window sub string
	 */
	static int findMinWindow(String s, String t) {
		int i=0,j=0;
		Map<Character,Integer> map = new HashMap<>();
		
		for( i = 0; i< t.length(); i++) {
			char ch = t.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) +1);
			}
			else {
				map.put(ch, 1);
			}
		}
		int count = map.size();
		int minLen = Integer.MAX_VALUE;
		
		while(j < t.length()) {
			  char c = s.charAt(j);
			  if(map.containsKey(c)) {
				  map.put(c, map.get(c)-1);
			      if(map.get(c) ==0) {
			    	  count--;
			      }
	         }
			  if(count!=0) {
				  j++;
			  }
			  else if(count ==0) {
				  while(count==0) {
					  char c2= s.charAt(i);
					  map.put(c2, map.get(c2)+1);
					  if(map.get(c2) >0) {
						  minLen = Math.min(minLen, j-i+1);
						  count++;
					  }
					  i++;
				  }
				  j++;
			  }
	    }
		return minLen;
	}
}
