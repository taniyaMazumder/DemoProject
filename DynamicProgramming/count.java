package DynamicProgramming;

public class count {

	public static void main(String[] args) {
		int[] a= {2, 5, 1, 100};
		System.out.println(isPossible(4,a));

	}
	public static int isPossible(int n, int[] nums) {
	if (nums == null || nums.length == 0) {
        return 0;
    }

    int totalProduct = 1;
    for (int num : nums) {
        totalProduct *= num;
    }

    return countPartitionsHelper(nums, 1, 0, totalProduct);
}

private static int countPartitionsHelper(int[] nums, int currentProduct, int index, int totalProduct) {
    if (index == nums.length) {
        if (currentProduct == totalProduct) {
            return 1;
        } else {
            return 0;
        }
    }

    int count = 0;

    // Include the current element in the current partition
    int left = countPartitionsHelper(nums, currentProduct * nums[index], index + 1, totalProduct);

    // Start a new partition
    int right = countPartitionsHelper(nums, nums[index], index + 1, totalProduct);

    if(containsZero(left) == containsZero(right)) {
        count++;
    }
    return count;
}
   public static int containsZero(int num) {
        while (num != 0) {
            if (num % 10 == 0) {
                return 1;
            }
            num /= 10;
        }
        return 0;
    }
}
