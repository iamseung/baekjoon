import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length - 1;
        int index = len;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = len; i >= 0; i--) {
            // B 팀원이 이기는 경우
            if (B[index] > A[i]) {
                // 승점 +1
                answer++;
                // B 의 Max 값 소모
                index--;
            }

            // 비기거나 B 의 수가 더 낮을 경우, 승점 X
        }

        return answer;
    }
}