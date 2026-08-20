class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        arr[0]=nums[0];
        arr[1]=nums[1];
        int s1=1,s2=1;
        for(int i=2;i<n;i++){
            int l1=arr[s1-1];
            int l2=arr[s1+s2-1];
            if(l1>l2){
                for(int j=s1+s2-1;j>=s1;j--)
                    arr[j+1]=arr[j];
                arr[s1]=nums[i];
                s1++;
            }else{
                arr[s1+s2]=nums[i];
                s2++;
            }
        }
        return arr;
    }
}