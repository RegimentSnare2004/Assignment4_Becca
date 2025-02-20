import java.util.Stack;

public class Problem5 {

    public static void main(String[] args) {
        String ex1 = "3[a]2[bc]";
        String ex2 = "3[a2[c]]";
        String ex3 = "2[abc]3[cd]ef";

        System.out.println(decodeString(ex1));
        System.out.println(decodeString(ex2));
        System.out.println(decodeString(ex3));
    }

    public static String decodeString(String s) {
        String result = "";
        Stack<Integer> stackCount = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                stackCount.push(s.charAt(i)-'0');
                i++;
            }
            else if(s.charAt(i) == '['){
                resStack.push(result);
                result = "";
                i++;
            }
            else if(s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder(resStack.pop());
                int numRepeat = stackCount.pop();
                for(int j = 0; j < numRepeat; j++){
                    temp.append(result);
                }
                result = temp.toString();
                i++;
            }
            else{
                result += s.charAt(i);
                i++;
            }


        }
        return result;
    }
}
