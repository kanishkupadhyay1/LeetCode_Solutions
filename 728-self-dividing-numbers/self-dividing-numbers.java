class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();

        for(int i=left;i<=right;i++){
            int n=i;
            boolean has0=false,is=true;
            while(n!=0){
                int di=n%10;
                if(di==0){
                    has0=true;
                    break;
                }
                if(i%di!=0){
                    is=false;
                    break;
                }
                n/=10;

            }
            if(has0)continue;

            if(is){
                ans.add(i);
            }
        }
        return ans;
    }
}