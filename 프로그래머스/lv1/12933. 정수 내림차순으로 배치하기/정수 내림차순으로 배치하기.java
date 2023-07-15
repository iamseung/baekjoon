import java.util.*;

class Solution {
    public long solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n >= 10) {
            list.add((int) (n%10));
            n /= 10;
        }
        
        list.add((int) n);
        
        // 내림차순
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int k : list) sb.append(String.valueOf(k));
        
        return Long.parseLong(sb.toString());
    }
}