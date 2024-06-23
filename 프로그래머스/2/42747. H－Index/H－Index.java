import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int len = citations.length;
        
        for(int i=0; i<len; i++) {
            // h편의 논문이 h회 이상의 조건
            int h = len - i;
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}