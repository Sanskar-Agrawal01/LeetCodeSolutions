class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int count = 0;
        int i = 0;

        while (i < n - 1) {
            int maxWeight = weight[i];
            int j = i + 1;

            while (j < n) {
                maxWeight = Math.max(maxWeight, weight[j]);

                if (weight[j] < maxWeight) {
                    count++;
                    i = j + 1;
                    break;
                }
                j++;
            }

            if (j == n) {
                break;
            }
        }

        return count;
    }
}
