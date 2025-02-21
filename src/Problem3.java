import java.util.Deque;
import java.util.LinkedList;

public class Problem3 {

    public static void main(String[] args){
        Deque<Integer> q = new LinkedList<>();
        q.add(6);
        q.add(7);
        q.add(6);
        q.add(8);
        q.add(16);
        q.add(6);
        int x = 8;
        System.out.println(dequeSearch(q, x));
    }

    public static int dequeSearch(Deque<Integer> q, int y){
        int startposition = 0;
        int value = 0;
        int endposition = q.size() - 1;
        while(!q.isEmpty()){
            value = q.removeFirst();
            if(value == y){
                return(startposition);
            }
            else{
                value = q.removeLast();
                if(value == y){
                    return(endposition);
                }
            }
            startposition ++;
            endposition --;
        }
        return startposition;
    }
}
