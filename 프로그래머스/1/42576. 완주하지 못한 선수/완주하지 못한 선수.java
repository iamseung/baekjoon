import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> list = new HashMap<>();
        
        String answer = "";
        
        for(String p : participant) {
            list.put(p, list.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion) {
            list.put(c, list.get(c) - 1);
        }
        
        for(String strKey : list.keySet()) {
            if(list.get(strKey) != 0) {
                answer = strKey;
                break;
                // return strKey;
            }
        }
        return answer;
    }
}