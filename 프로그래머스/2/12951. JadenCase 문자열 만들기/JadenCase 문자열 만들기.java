class Solution {
    public String solution(String s) {
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            if(i == 0 || s.charAt(i-1) == ' ') {
                answer += String.valueOf(s.charAt(i)).toUpperCase();
            } else {
                answer += String.valueOf(s.charAt(i)).toLowerCase();
            }
        }

        return answer;
    }
}