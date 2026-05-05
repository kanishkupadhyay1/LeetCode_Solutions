import java.util.*;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        
        for (int candy : candyType) {
            set.add(candy);
        }
        
        int maxAllowed = candyType.length / 2;
        return Math.min(set.size(), maxAllowed);
    }
}