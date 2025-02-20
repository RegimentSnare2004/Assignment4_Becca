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
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.push(s.charAt(i)-'0');
            }
            else if (s.charAt(i) == '[') {
                String toAdd = "";
                int j = i + 1;

                while (s.charAt(j) != ']') {
                    toAdd += s.charAt(j);
                    j++;
                    i++;
                }

                int count = 0;
                if(!stack.isEmpty()) {
                    while (count < stack.pop()) {
                        result += toAdd;
                        count++;
                    }
                }

            }

        }
        return result;
    }
}
