import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Map<Character, Integer> idxMap= new HashMap<>();

        for(int i=0; i<skill.length(); i++)
            idxMap.put(skill.charAt(i), i);

        for(String s : skill_trees) {
            answer += cal(s, idxMap);
        }

        return answer;
    }

    static int cal(String s, Map<Character, Integer> idxMap) {
        int idx = 0;

        for(int i=0; i<s.length(); i++) {
            if(idxMap.containsKey(s.charAt(i))) {
                if(idxMap.get(s.charAt(i)) != idx)
                    return 0;

                idx++;
            }
        }

        return 1;
    }
}