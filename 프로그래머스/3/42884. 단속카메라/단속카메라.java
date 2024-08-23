import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        // 종료 지점을 기준으로 오름 차순
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int last = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            // 하나의 카메라로 다음 구간을 측정할 수 있다면 pass
            if (routes[i][0] <= last && last <= routes[i][1])
                continue;

            last = routes[i][1];
            answer++;
        }

        return answer;
    }
}