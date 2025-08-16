import java.util.ArrayList;

class Solution {
    public static boolean isPrime(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return false; 
        }
    }
    return true; 
}

    public long splitArray(int[] nums) {
        if(nums.length  == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.abs(nums[0] + nums[1]);
        }
      List<Integer> A = new ArrayList<>();
      List<Integer> B = new ArrayList<>();

      for(int i = 0;i<nums.length;i++){
        if(isPrime(i)){
            A.add(nums[i]);
        }
        else{
            B.add(nums[i]);
        }
      }
      long c1 =0;
       for(int i = 0;i<A.size();i++){
          c1+=A.get(i);
       }
       long c2 = 0;
       for(int i = 0;i<B.size();i++){
          c2+=B.get(i);
       }
       return Math.abs(c1 - c2);
    }
}
