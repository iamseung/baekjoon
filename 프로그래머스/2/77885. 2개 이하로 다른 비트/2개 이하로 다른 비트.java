import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            if (x % 2 == 0) {
                // 짝수인 경우, 1을 더함
                answer[i] = x + 1;
            } else {
                // 홀수인 경우
                // 가장 낮은 0 비트를 찾아서 1로 만들고, 그 바로 오른쪽 비트를 0으로 만듦
                long rightmostZero = ~x & (x + 1); // 가장 낮은 0 비트 위치를 찾음
                long rightmostOne = rightmostZero >> 1; // 가장 낮은 1 비트 위치를 찾음
                answer[i] = x + rightmostZero - rightmostOne;
            }
        }
        
        return answer;
    }
}