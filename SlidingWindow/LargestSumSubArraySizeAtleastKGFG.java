package SlidingWindow;

public class LargestSumSubArraySizeAtleastKGFG {

	public static void main(String[] args) {
//		long a[] = {1, -2, 2, -3};
//		long a[] = {-4,-2, 1, -3};
//		long a[] = {1, 1, 1, 1, 1, 1};
//		long k=2;
		long a[] = {6, -9, -5, 4, -3, 7};
		long n = a.length;
		long k=3;
		
		System.out.println(maxSumWithK(a,n,k));

	}

	public static long maxSumWithK(long a[], long n, long k)
    {
        int i=0,j=0;
        long sum=0,maxSum = Integer.MIN_VALUE;
        long last=0;
        
        while(j<a.length) {
        	sum = sum + a[j];
        	
        	if(j-i+1 <k) {
        		j++;
        	}
        	else if(j-i+1 == k) {
        		maxSum = Math.max(maxSum, sum);
        		j++;
        	}
        	else if(j-i+1 >k) {
        			maxSum = Math.max(maxSum, sum);
        			
	        		last = last +  a[i];
	        		i++;
	        		if(last <0) {
	        			sum = sum - last;
	        			last = 0;
	        			maxSum = Math.max(maxSum, sum);
	        		}
	        		j++;
        		}
        	}
        
        return maxSum;
    }
}
