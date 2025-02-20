import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stack<Integer> example = new Stack<Integer>();
        example.push(8);
        example.push(2);
        example.pop();
        example.push(example.pop()*2);
        example.push(10);
        example.push((example.pop()/2));
        System.out.println(example);

        Queue<Integer> example2 = new LinkedList<Integer>();
        example2.add(4);
        example2.add(example2.remove()+4);
        example2.add(8);
        example2.add(example2.remove()/2);
        example2.remove();
        example2.remove();
        System.out.println(example2);

        Deque<Integer> q = new LinkedList<Integer>();
        q.add(6);
        q.add(7);
        q.add(6);
        q.add(8);
        q.add(16);
        q.add(6);
        int x = 8;
        int startposition = 0;
        int value = 0;
        int endposition = q.size() - 1;
        while(!q.isEmpty()){
            value = q.removeFirst();
            if(value == x){
                System.out.println(startposition);
            }
            else{
                value = q.removeLast();
                if(value == x){
                    System.out.println(endposition);
                }
            }
            startposition ++;
            endposition --;
        }
    }
}