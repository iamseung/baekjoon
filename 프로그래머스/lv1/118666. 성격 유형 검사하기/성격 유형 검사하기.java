import java.util.*;
import java.io.*;
class Solution {
    static char[][] type = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
    static int[] alpha = new int[26];
    static StringBuilder sb = new StringBuilder();
    static String MBTI = "";
    
    public String solution(String[] survey, int[] choices) {
        for(int i=0; i<survey.length; i++) cal(survey[i], choices[i]);
        makeMBTI();
        return sb.toString();
    }
    
    // String : MBTI 생성
    public static void makeMBTI() {
        for(char[] t : type) {
            if(alpha[t[0] -'A'] > alpha[t[1] -'A']) {
                sb.append(t[0]);
            } 
            else if(alpha[t[0] -'A'] < alpha[t[1] -'A']) {
                sb.append(t[1]);
            }
            else {
                Arrays.sort(t);
                sb.append(t[0]);
            }
        }
    }
    
    // 점수 계산
    public static void cal(String s, int c) {
        if(c <=3) {
            alpha[s.charAt(0)-'A'] += 4-c;
        }
        
        if(c >=5) {
            alpha[s.charAt(1)-'A'] += c-4;
        }
    }
}