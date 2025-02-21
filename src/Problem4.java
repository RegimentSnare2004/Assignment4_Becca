
import java.util.Stack;

public class Problem4 {

    public static void main(String[] args){
        String ex1 = "{[()]}";
        String ex2 = "{[(])}";
        String ex3 = "{{[[(())]]}}";

        System.out.println(isBalanced(ex1));
        System.out.println(isBalanced(ex2));
        System.out.println(isBalanced(ex3));
    }

    public static String isBalanced(String s){
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()){
                    answer = false;
                }
                if((s.charAt(i) == '}' && stack.pop() != '{') ||
                        (s.charAt(i) == ']' && stack.pop() != '[') ||
                        (s.charAt(i) == ')' && stack.pop() != '(')){
                    answer = false;

                }

            }
        }
        if(answer){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}
