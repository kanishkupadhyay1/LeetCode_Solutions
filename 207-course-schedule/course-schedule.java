class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());   // initialize an empty list for each cource
        }
        for(int[]p : prerequisites){       // put the reqirement for each course 
            graph.get(p[1]).add(p[0]);
        }

        int state[]=new int[numCourses];


        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(dfs(graph,i,state))return false;
            }
        }
return true;
    }

    public boolean dfs(List<List<Integer>> graph,int i,int[] state){
        if(state[i]==1)return true; //cycle

        if(state[i]==2)return false; //safe;

        state[i]=1;
        for(int n : graph.get(i)){
            if(dfs(graph,n,state))return true;
        }
        state[i]=2;
        return false;
    }
}