class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s : babbling) {
            // 연달아 발음하는 경우
            s = s.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            
            s = s.replaceAll("aya|ye|woo|ma", "");
            
            if(s.length() == 0) answer++;
        }
        return answer;
    }
}