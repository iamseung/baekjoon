import java.util.*;

class Solution {
    public String solution(String s) {
         StringBuilder answer = new StringBuilder();
        /* 첫번째 문자 여부 */
        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(s.charAt(i));
                isFirst = true; /* 공백 다음엔 첫번째 문자 */
            } else {
                if (isFirst) { /* 첫번째 문자의 경우 */
                    answer.append(String.valueOf(s.charAt(i)).toUpperCase());
                    isFirst = false; /* 첫번째 문자가 아님 */
                } else {
                    answer.append(String.valueOf(s.charAt(i)).toLowerCase());
                }
            }
        }

        return answer.toString();
    }
}