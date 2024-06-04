class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(char s : my_string.toCharArray()) {
            // 숫자 판별
            if(Character.isDigit(s))
                answer += s-'0';
        }
        return answer;
    }
}