class Solution {
    
    public int calculate(String s) {
        int result=0;
        int sig=1;

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int num=0;

                    while(i<s.length() && Character.isDigit(s.charAt(i))){
                        num=num*10+(s.charAt(i)-'0');
                        i++;
                    }

                    result+=sig*num;
                    i--;
            }else if(c=='+'){
                sig=1;
            }else if(c=='-'){
                sig=-1;
            }else if(c=='('){
                st.push(result);
                st.push(sig);

                result=0;
                sig=1;
            }else if(c==')'){
                result=result*st.pop();
                result+=st.pop();
            }
        }
        return result;
    }
}