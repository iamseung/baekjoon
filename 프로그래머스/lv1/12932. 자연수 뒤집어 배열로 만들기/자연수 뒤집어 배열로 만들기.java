import java.util.*;

class Solution {
    public int[] solution(long n) {       
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n>=10) {
            list.add((int) (n%10));
            n /= 10;
        }
        
        list.add((int) n);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}