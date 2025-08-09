class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        int positiveSum = 0;
        boolean hasPositive = false;
        int maxNumber = Integer.MIN_VALUE;

        for (int num : nums) {
            maxNumber = Math.max(maxNumber, num);
            if (num > 0 && unique.add(num)) {
                positiveSum += num;
                hasPositive = true;
            }
        }

        return hasPositive ? positiveSum : maxNumber;
    }
}