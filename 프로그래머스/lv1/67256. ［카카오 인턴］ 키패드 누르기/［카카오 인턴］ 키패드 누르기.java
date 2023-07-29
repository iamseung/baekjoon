import java.util.*;

class Solution {
    // 왼손, %3 == 1
    // 오른손, %3 == 0
    // 가운데, %3 == 2, 0은 11
    static int indexLeft = 10, indexRight = 12; 
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        for(int n : numbers) {
            if(n == 0) n = 11;
            if(n%3 == 1) {
                answer += "L";
                indexLeft = n;
            } else if(n%3 == 0) {
                answer += "R";
                indexRight = n;
            }else {
                answer += howToMove(n, hand);
            }
        }
        
        return answer;
    }
    
    static String howToMove(int N, String hand) {
        int leftdist = Math.abs(N - indexLeft) / 3 + Math.abs(N - indexLeft) % 3;
        int rightdist = Math.abs(N - indexRight) / 3 + Math.abs(N - indexRight) % 3;
        if(leftdist < rightdist) {
            indexLeft = N;
            return "L";
        } else if (leftdist > rightdist) {
            indexRight = N;
            return "R";
        }
        
        if(hand.equals("right")) {
            indexRight = N;
            return "R";
        } else {
            indexLeft = N;
            return "L";
        } 
    }
}