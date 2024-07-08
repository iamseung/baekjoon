import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] transedString = Integer.toString(n,k).split("0");

        for(String t : transedString) {
            if(isPrime(t))
                answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(String s) {
        if(s.length() == 0)
            return false;
        
        Long N = Long.parseLong(s);

        if(N < 2)
            return false;

        for(int i=2; i<= (int) Math.sqrt(N); i++)
            if(N % i == 0)
                return false;

        return true;
    }
}