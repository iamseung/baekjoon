import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        // 배열의 크기는 결국 right값 - left값 + 1만큼
        int[] answer = new int[(int) ((right-left)+1)];
        
        int index = 0;
        for(long i = left ; i<=right;i++){
            answer[index++] = (int) Math.max((i/n)+1 , i%n+1);
        }
        return answer;
    }
}