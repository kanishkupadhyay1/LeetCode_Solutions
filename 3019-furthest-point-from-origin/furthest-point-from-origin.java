class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch : moves.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int ans=mp.getOrDefault('_',0);
        if(mp.getOrDefault('L',0)>mp.getOrDefault('R',0)){
            ans+=mp.getOrDefault('L',0);
            ans-=mp.getOrDefault('R',0);
        }else{
            ans+=mp.getOrDefault('R',0);
            ans-=mp.getOrDefault('L',0);
        }
        return ans;
    }
}