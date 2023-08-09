import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        // 카운트할 map
        HashMap<String, Integer> count = new HashMap<>();
        
        char last =words[0].charAt(0);
        for(int i=0; i<words.length; i++) {
            // 단어가 2번 사용되는 경우
            if(count.containsKey(words[i])) {
                // i번 사람이 자신의 j번 차례
                return new int[] {i%n+1, i/n+1};
            }
            // 단어가 지속되지 않는 경우
            if(last != words[i].charAt(0)) {
                return new int[] {i%n+1, i/n+1};
            }
            
            count.put(words[i], count.getOrDefault(words[i], 0) + 1);
            
            last = words[i].charAt(words[i].length()-1);
        }
        
        return new int[] {0,0};
    }
}