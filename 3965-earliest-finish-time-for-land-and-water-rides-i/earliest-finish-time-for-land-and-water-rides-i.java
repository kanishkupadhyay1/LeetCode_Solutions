class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                int finishLand = landStartTime[i] + landDuration[i];
                ans = Math.min(
                    ans,
                    Math.max(finishLand, waterStartTime[j]) + waterDuration[j]
                );

                int finishWater = waterStartTime[j] + waterDuration[j];
                ans = Math.min(
                    ans,
                    Math.max(finishWater, landStartTime[i]) + landDuration[i]
                );
            }
        }

        return ans;
    }
}