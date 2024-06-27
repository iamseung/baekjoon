import java.util.*;

class Solution {
    static final int popMax = 1;
    static final int popMin = -1;
    static final String INSERT = "I";
    static final String DELETE = "D";
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder()); // 큰 것부터 pop
        PriorityQueue<Integer> minQ = new PriorityQueue<>(); // 작은 것부터 pop

        StringTokenizer st;
        for(String s : operations) {
            st = new StringTokenizer(s, " ");
            String command = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if(command.equals(INSERT)) {
                maxQ.offer(value);
                minQ.offer(value);
            }

            if(command.equals(DELETE)) {
                // 최댓값 삭제
                if(value == popMax) {
                    minQ.remove(maxQ.poll());
                }

                // 최솟값 삭제
                if(value == popMin) {
                    maxQ.remove(minQ.poll());
                }
            }
        }

        if(maxQ.isEmpty() || minQ.isEmpty())
            return new int[]{0,0};

        return new int[]{maxQ.poll(), minQ.poll()};
    }
}