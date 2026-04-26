class Solution {
    int m,n;
    boolean[][] vis;

    public boolean containsCycle(char[][] grid){
        m=grid.length;
        n=grid[0].length;
        vis=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(dfs(grid,i,j,-1,-1,grid[i][j]))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] g,int r,int c,int pr,int pc,char ch){
        if(vis[r][c]) return true;

        vis[r][c]=true;

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int i=0;i<4;i++){
            int nr=r+dr[i], nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<m && nc<n && g[nr][nc]==ch){
                if(nr==pr && nc==pc) continue;

                if(dfs(g,nr,nc,r,c,ch))
                    return true;
            }
        }

        return false;
    }
}