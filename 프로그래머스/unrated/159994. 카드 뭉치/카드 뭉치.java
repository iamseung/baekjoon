import java.util.*;
class Solution 
{
    public String solution(String[] cards1, String[] cards2, String[] goal) 
    {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        for(String str : cards1) q1.offer(str);
        for(String str : cards2) q2.offer(str);
        
        for(String g : goal) {
            if(q1.peek() != null && q1.peek().equals(g)) {
                q1.poll();
            }
            else if(q2.peek() != null && q2.peek().equals(g)) {
                q2.poll();
            }
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}