class Solution {
    public String[] findRelativeRanks(int[] score) {
        String ans[]=new String[score.length];

        int arr[][]=new int[score.length][2];

        for(int i=0;i<score.length;i++){
            arr[i][0]=score[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr,(a,b)-> b[0]-a[0]);

        for (int i = 0; i < score.length; i++) {
    int idx = arr[i][1];

    if (i == 0) ans[idx] = "Gold Medal";
    else if (i == 1) ans[idx] = "Silver Medal";
    else if (i == 2) ans[idx] = "Bronze Medal";
    else ans[idx] = String.valueOf(i + 1);
}

return ans;
    }
}