class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int ans[] = new int[queries.length];
        int idx = 0;
        for (int nums[] : queries) {
            int x = nums[0];
            int y = nums[1];
            int r = nums[2];
            int cnt = 0;
            r = (int) Math.pow(r, 2);
            for (int pts[] : points) {
                int x2 = pts[0];
                int y2 = pts[1];
                int dist = Euclidean(x, y, x2, y2);
                if (dist <= r) {
                    cnt++;
                }
            }
            ans[idx] = cnt;
            idx++;
        }
        return ans;
    }

    public static int Euclidean(int x1, int y1, int x2, int y2) {
        return (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}