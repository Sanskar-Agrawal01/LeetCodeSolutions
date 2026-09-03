class Solution {
    public boolean uniformArray(int[] nums1) {
       Arrays.sort(nums1);
       int min = nums1[0];
       if(min % 2 != 0) return true;
        if (min % 2 == 0) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] % 2 == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}