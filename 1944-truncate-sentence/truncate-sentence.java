class Solution {
    public String truncateSentence(String s, int k) {

        String[] words = s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();


        for(int count=0;count<k;count++){
            if(count+1==k){
            sb.append(words[count]);
            }else{
                sb.append(words[count]+" ");
            }
        }
        return sb.toString();
    }
}