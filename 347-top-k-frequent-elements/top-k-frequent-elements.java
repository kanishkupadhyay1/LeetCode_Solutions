class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int arr[]=new int[k];
        Map<Integer,Integer> fre=new HashMap<>();
        for(int n:nums){
            fre.put(n,fre.getOrDefault(n,0)+1);
        }
        int i=0;
        List<Map.Entry<Integer,Integer>> top=new ArrayList<>(fre.entrySet());
        top.sort((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> zz : top){
            if(i==k){
                break;
            }
            arr[i]=zz.getKey();
            i+=1;
        }
return arr;
    }
}