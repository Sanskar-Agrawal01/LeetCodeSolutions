class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int costs = 0;
        for (int i = 0; i < cost.length; i++)
            costs += cost[i];
        int idx = cost.length - 1;
        idx = idx - 2;
        while (idx >= 0) {
            costs -= cost[idx];
            idx = idx - 3;
        }
        return costs;

    }
}