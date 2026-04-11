class Solution {
    public int lengthOfLongestSubstring(String s) {
        int le=0,ml=0;
        Set<Character> se=new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(se.contains(s.charAt(i))){
               se.remove(s.charAt(le));
               le++;
            }
            se.add(s.charAt(i));
            ml=Math.max(ml,i-le+1);
        }
        return ml;
    }
}