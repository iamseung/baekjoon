import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set1 = new HashSet<>(List.of(gems));
        Set<String> set2 = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (r < gems.length) {
            map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
            set2.add(gems[r]);
            while (map.get(gems[l]) > 1) {
                map.replace(gems[l], map.get(gems[l]) - 1);
                l++;
            }
            if (r - l < len && set1.size() == set2.size()) {
                answer[0] = l + 1;
                answer[1] = r + 1;
                len = r - l;
            }
            r++;
        }
        return answer;
    }
}