class Solution {
    public void rotate(int[][] matrix) {
        int trans[][]=new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
               trans[j][i] =matrix[i][j];
            }
        }
        for(int i=0;i<trans.length;i++){
        int f=0,l=trans.length-1;
       while(l>f ){
        int temp=trans[i][f];
        trans[i][f]=trans[i][l];
        trans[i][l]=temp;
        l-=1;f+=1;
       }}
        for(int i=0;i<trans.length;i++){
            for(int j=0;j<trans[i].length;j++){
               matrix[i][j] =trans[i][j];
            }
        }
        
    }
}