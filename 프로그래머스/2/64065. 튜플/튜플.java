import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> count = new HashMap<>();
        
        s = s.substring(2, s.length() - 2);
        
        // "},{" 로 문자열을 분할
        String[] parts = s.split("},\\{");

        for (String part : parts) {
            // 각 부분을 콤마로 분할하여 숫자로 변환
            for (String numStr : part.split(",")) 
                count.put(numStr, count.getOrDefault(numStr, 0) +1);
        }
        
        return count.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
            .mapToInt(entry -> Integer.parseInt(entry.getKey()))
            .toArray();
    }
}