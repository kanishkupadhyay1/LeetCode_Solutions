class Solution {
    public int rotatedDigits(int n) {

        int count=0;
        int num;

        for(int i=0;i<=n;i++){
            num=i;
            boolean valid=true;
            boolean changed=false;


            while(num>0){
                int digit=num%10;

                if(digit==3 ||digit==4 || digit == 7){
                    valid=false;
                    break;
                }else if( digit==2 || digit== 5 || digit== 6 || digit== 9){
                    changed=true;
                }
                num/=10;
            }
            if(valid && changed)count++;
        }
        
        return count;
    }
}