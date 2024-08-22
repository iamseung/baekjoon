import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s)
            return new int[] { -1 };

        int[] answer = new int[n];

        // s 를 n 개에 적절히 분배
        Arrays.fill(answer, s / n);

        // 남은 만큼 추가로 분배
        for (int i = 0; i < s % n; i++)
            answer[i]++;

        // 오름차순 정렬
        Arrays.sort(answer);

        return answer;
    }
}