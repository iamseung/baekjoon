import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // brideg_length 만큼의 크기를 갖는 큐 생성
        Queue<Integer> bridge = new LinkedList<>();

        // 맨 처음 비어있는 다리 공간 모두를 0으로 초기화
        for (int i = 0; i < bridge_length; i++)
            bridge.offer(0);

        // 다리 길이가 1이거나 트럭의 개수가 1일 경우
        if (bridge_length == 1) return truck_weights.length + 1;
        if (truck_weights.length == 1) return bridge_length + 1;

        int idx = 0;
        // 현재 다리에 있는 모든 트럭의 무게
        int curWeight = 0;

        // 트럭의 개수만큼 계속 반복
        while (idx < truck_weights.length) {
            // 현재 다리에 존재하는 맨 앞 트럭의 무게를 차감 -> 다리를 지나감
            curWeight -= bridge.poll();
            // 새로운 트럭 넣기
            answer++;

            if (curWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                curWeight += truck_weights[idx++];
            } else {
                // 트럭을 넣을 수 없는 경우엔 0 을 넣어줌
                bridge.offer(0);
            }
        }

        return answer + bridge_length;
    }
}