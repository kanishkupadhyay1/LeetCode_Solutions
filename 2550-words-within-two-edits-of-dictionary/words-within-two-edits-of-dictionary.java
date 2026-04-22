class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> sol=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            char[] word=queries[i].toCharArray();

            for(int j=0;j<dictionary.length;j++){
                char[] c=dictionary[j].toCharArray();
                int count=0;
                for(int k=0;k<c.length;k++){
                    if(word[k]!=c[k]){
                        count++;
                    }
                    if(count>2)break;
                }
                if(count<=2)
                {sol.add(queries[i]);
                break;
                }

            }
        }
        return sol;
    }
}