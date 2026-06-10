class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        long need = (long) Math.ceil(brightness / 3.0);
        Arrays.sort(intervals, (a ,b) -> Integer.compare(a[0], b[0]));
        List<int [] > list = new ArrayList<>();
        int [] current = intervals[0];
        for(int i = 1;i<intervals.length;i++) {
            if(current[1] >= intervals[i][0]){
                current[1] = Math.max(current[1], intervals[i][1]);
            }
            else{
                list.add(current);
                current = intervals[i];
            }
        }
        list.add(current);
        long sum = 0;
        for(int [] arr : list){
           int a = arr[0];
           int b = arr[1];
           int temp = b -a +1;
           sum+=temp;

        }
        return sum*need;
    }
}