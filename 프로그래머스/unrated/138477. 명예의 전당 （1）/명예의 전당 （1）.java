import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<score.length; i++) {
            q.offer(score[i]);
            
            if(q.size() > k) q.poll();
    
            answer[i] = q.peek();
        }
        
        return answer;
    }
}