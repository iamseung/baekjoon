import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int L = 0, R = 0, sum = 0;
        int gap = Integer.MAX_VALUE;
        int[] answer = { -1, -1 };

        while (R < sequence.length) {
            // sum을 k에 맞추거나 k보다 크게 만들기 위해 R을 이동시키기
            if (sum < k) {
                sum += sequence[R++];
            }

            // 합이 k 이상인 경우
            while (sum >= k) {
                // 최소 길이를 찾으며 L을 이동시키기
                if (sum == k && (R - L) < gap) {
                    gap = R - L;
                    answer[0] = L;
                    answer[1] = R - 1; // R은 이미 다음 위치를 가리키므로 -1 조정
                }

                sum -= sequence[L++];
            }
        }

        return answer;
    }
}