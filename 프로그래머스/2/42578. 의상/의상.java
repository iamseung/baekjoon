import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cloMap = new HashMap<>();
        
        // 의류 별 갯수 체크
        for(String[] c : clothes)
            cloMap.put(c[1], cloMap.getOrDefault(c[1], 0) + 1);

        for(String key : cloMap.keySet())
            answer *= cloMap.get(key)+1;
        
        return answer - 1;
    }
}