class Solution {
    public int earliestFinishTime(int[] Time, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
         int minFinishTime = Integer.MAX_VALUE;

        for (int i = 0; i < Time.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                int landfinish = Time[i] + landDuration[i];

                int waterstart = Math.max(landfinish, waterStartTime[j]);

                int total1 = waterstart + waterDuration[j];

                minFinishTime = Math.min(minFinishTime, total1);


                int currentTime = waterStartTime[j] + waterDuration[j];

                int landRideStartAfterWater = Math.max(currentTime, Time[i]);

                int total2 = landRideStartAfterWater + landDuration[i];

                minFinishTime = Math.min(minFinishTime, total2);
            }
        }

        return minFinishTime;
        
    }
}