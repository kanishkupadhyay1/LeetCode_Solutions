class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        long result=0;boolean n=false;int i=0;
        if(s.length()>0){
        if(s.charAt(0)=='-'){
                 n=true;
                 i++;

            }else if(s.charAt(0)=='+'){
                i++;
            }}
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            result=result*10+(s.charAt(i)-'0');
        
        if (!n && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (n && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;}
        
        return n? (int)-result : (int)result;
    }
}