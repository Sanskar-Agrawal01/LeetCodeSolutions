class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
         int n = prices.length;

       
        long baseProfit = 0;
        long[] contrib = new long[n];
        for (int i = 0; i < n; i++) {
            contrib[i] = (long) strategy[i] * prices[i];
            baseProfit += contrib[i];
        }

        
        long[] prefixContrib = new long[n+1];
        long[] prefixPrices = new long[n+1];
        for (int i = 0; i < n; i++) {
            prefixContrib[i+1] = prefixContrib[i] + contrib[i];
            prefixPrices[i+1] = prefixPrices[i] + prices[i];
        }

       
        long maxDelta = 0;
        int half = k / 2;
        for (int start = 0; start + k <= n; start++) {
            int mid = start + half;
            int end = start + k;

           
            long remove = prefixContrib[mid] - prefixContrib[start];

           
            long addPrices = prefixPrices[end] - prefixPrices[mid];
            long removeContrib = prefixContrib[end] - prefixContrib[mid];

            long delta = -remove + (addPrices - removeContrib);
            maxDelta = Math.max(maxDelta, delta);
        }

        return  (baseProfit + maxDelta);
    }
}