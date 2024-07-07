import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        for(int i=0; answer.length() <= t*m; i++)
            answer += Integer.toString(i, n);

        StringBuilder sb = new StringBuilder();

        for(int i=p-1; sb.length()<t; i += m)
            sb.append(String.valueOf(answer.charAt(i)));

        return sb.toString().toUpperCase();
    }
}