class Solution {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int h = k + 1; h < nums.length; h++) {
                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[k];
                        int d = nums[h];
                        if (a + b + c == d) {
                            count++;
                        }
                    }

                }
            }
        }
        return count;
    }
}