import java.util.Stack;

public class Problem6 {

    public static void main(String[] args){
        String input = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(postFix(input));
    }
    public static int precedence(char c){
        if(c == '^'){
            return 3;
        }
        else if(c == '/' || c== '*'){
            return 2;
        }
        else if(c == '+' || c == '-'){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static String postFix(String s){
        String result = "";
        Stack<Character> operators = new Stack<>();
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                output.append(s.charAt(i));
            }
            else if(s.charAt(i) == '('){
                operators.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                while(operators.peek() != '('){
                    output.append(operators.pop());
                }
                operators.pop();
            }
            else{
                while(!operators.isEmpty() && (precedence(s.charAt(i)) < precedence(operators.peek())
                || precedence(s.charAt(i)) == precedence(operators.peek()))){
                    output.append(operators.pop());
                }
                operators.push(s.charAt(i));
            }
        }
        while(!operators.isEmpty()){
            output.append(operators.pop());
        }
        result = output.toString();
        return result;
    }
}
