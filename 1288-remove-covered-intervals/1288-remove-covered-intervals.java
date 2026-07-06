class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int cnt = 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        int max =0;
        for(int tmp[] : intervals){
            if(tmp[1] > max){
                cnt++;
                max = tmp[1];
            }
        }
        return  cnt;
    }
}