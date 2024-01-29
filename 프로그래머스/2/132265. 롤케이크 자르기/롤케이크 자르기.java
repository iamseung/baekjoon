import java.util.*;

class Solution {
    static int[] N = new int[10001];
    static Set<Integer> set= new HashSet<>();
    public int solution(int[] topping) {
        int ANS = 0, right = 0;
        for(int t : topping) {
            if(N[t] == 0) {
                right++;
            }
            
            N[t]++;
        }
        
        for(int i=0; i<topping.length; i++) {
            // 왼쪽에 토핑 추가
            set.add(topping[i]);
            // 오른쪽 토핑에서 제거
            N[topping[i]]--;
            if(N[topping[i]] == 0) right--;
            
            if(set.size() ==  right) ANS++;
        }
        
        return ANS;
    }
}