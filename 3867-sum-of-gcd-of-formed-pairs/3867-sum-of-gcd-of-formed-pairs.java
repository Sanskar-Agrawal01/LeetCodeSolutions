class Solution {
    public long gcdSum(int[] nums) {
        int pref[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            pref[i] = gcd(nums[i], max);
        }
        Arrays.sort(pref);
        int i = 0;
        int j = pref.length - 1;
        long sum = 0;
        while(i < j){
            sum += gcd(pref[i], pref[j]);
            i++;
            j--;
        }
        return sum;
    }
    public static int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b  = a % b;
            a = temp;
        }
        return a;
    }
}