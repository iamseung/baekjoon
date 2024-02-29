class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        
        while(storey > 0) {
            // 나머지 계산
            int digit = storey % 10;
            storey /= 10;
            
            if(digit > 5) {
                // 10으로 만드는게 유리, [ex] 6 -> 10
                answer += 10 - digit;
                // 10으로 맞춰주니 10의 자리수 +1
                storey++;
            } else if(digit < 5) {
                // -1씩 해서 0으로, [ex] 4 -> 0
                answer += digit;
            } else {
                // 5인 경우에 그 앞의 자리수를 고려
                if (storey%10 >= 5) {
                    // UP
                    answer += (10 - digit);
                    storey++;
                }
                else {
                    // DOWN
                    answer += digit;    
                }
            }
        }
        
        return answer;
    }
}