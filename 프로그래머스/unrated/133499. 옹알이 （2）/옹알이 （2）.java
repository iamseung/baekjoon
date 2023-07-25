class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            str = str.replace("aya", "");
            str = str.replace("ye", "");
            str = str.replace("woo", "");
            str = str.replace("ma", "");
            
            if(str.length() == 0) answer++;
        }
        return answer;
    }
}