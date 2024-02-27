class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] numbers = {"4", "1", "2"}; // 0, 1, 2 나머지에 해당하는 값

        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            // 3으로 나누어 떨어질 경우, 몫에서 1을 빼줘야 함
            if (remainder == 0) n -= 1;

            // 나머지에 해당하는 값을 앞쪽에 추가
            answer.insert(0, numbers[remainder]);
        }

        return answer.toString();
    }
}