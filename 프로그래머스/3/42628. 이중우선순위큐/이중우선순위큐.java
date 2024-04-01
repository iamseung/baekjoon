import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st;
        String type;
        int N;
        for(String o : operations) {
            
            st = new StringTokenizer(o, " ");
            type = st.nextToken();
            N = Integer.parseInt(st.nextToken());

            if(type.equals("I")) {
                minQ.add(N);
                maxQ.add(N);
            }
            else {
                if(minQ.size() != 0) {
                    // 최대값 삭제
                    if(N == 1) {
                        int max = maxQ.poll();
                        minQ.remove(max);
                    }
                    // 최솟값 삭제
                    else {
                        int min = minQ.poll();
                        maxQ.remove(min);
                    }  
                }
            }
        }
        
        if(minQ.size() == 0 || maxQ.size() == 0) {
           answer = new int[]{0,0};
        } else {
            answer[1] = minQ.poll();
            answer[0] = maxQ.poll();   
        }
         
        return answer;
    }
}