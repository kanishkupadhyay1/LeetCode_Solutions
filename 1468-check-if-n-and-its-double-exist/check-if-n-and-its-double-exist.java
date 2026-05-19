class Solution {

    public boolean checkIfExist(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int n : arr) {

            if(n == 0) {

                if(map.get(0) > 1) {
                    return true;
                }

            } else {

                if(map.containsKey(n * 2)) {
                    return true;
                }
            }
        }

        return false;
    }
}