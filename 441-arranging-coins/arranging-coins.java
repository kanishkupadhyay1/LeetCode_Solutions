class Solution {
    public int arrangeCoins(int n) {
        int count=0;
        for(int i=0;i<n;i++,n=n-i){
            count++;
        }
        return count;
    }
}