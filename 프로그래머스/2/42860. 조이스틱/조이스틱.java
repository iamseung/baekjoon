class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 오른쪽으로 쭉 간 횟수
        
        for(int i = 0; i < len; i++) {
            // 위로 조작, 아래 조작 중 더 작은 것을 채택
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));

            // 좌,우 조작 / 연속된 'A'를 찾는다
            if (i < len - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;

                while(endA < len && name.charAt(endA) == 'A')
                    endA++;

                // 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i * 2 + (len - endA));
                // 왼쪽으로 갔다 다시 오른쪽으로 꺾기
                move = Math.min(move, i + (len - endA) * 2);
            }
        }

        return answer + move;
    }
}