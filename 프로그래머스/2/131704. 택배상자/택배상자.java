import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 컨테이너에 들어갈 idx 번호
        int idx = 0;
        int count = 0;

        Stack<Integer> container = new Stack<>();

        for(int i=0; i<order.length; i++) {
            if(order[idx] - 1 != i) {
                container.add(i);
                continue;
            }

            container.add(i);

            while(!container.isEmpty() && container.peek() == order[idx] - 1) {
                container.pop();
                idx++;
                count++;
            }
        }

        return count;
    }
}