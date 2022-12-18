import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sc = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*")  || s.equals("/")){
                int b = sc.pop();
                int a = sc.pop();
                if(s.equals("+")){
                    sc.add(a+b);
                }
                else if(s.equals("-")){
                    sc.add(a-b);
                }
                else if(s.equals("*")){
                    sc.add(a*b);
                }
                else{
                    sc.add(a/b);
                }
            }
            else{
                sc.add(Integer.parseInt(s));
            }
        }
        return sc.peek();
    }
}