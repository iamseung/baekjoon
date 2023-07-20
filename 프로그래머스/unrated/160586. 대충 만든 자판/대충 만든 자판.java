import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for(String str : keymap) {
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(!map.containsKey(c) || i < map.get(c)) {
                    map.put(c, i+1);
                }
            }
        }
        
        // 비교
        for(int i=0; i<targets.length; i++) {
            for(int j=0; j<targets[i].length(); j++) {
                if(!map.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                }
                
                // 0부터 인덱스를 잡기 때문에 +1
                answer[i] += map.get(targets[i].charAt(j));
            }
        }
        
        return answer;
    }
}