import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {        
        List<String> cache = new ArrayList<>();
        
        if(cacheSize == 0) 
            return 5 * cities.length;
        
        int time = 0;
        
        for(String c : cities) {
            String city = c.toUpperCase();
            
            // Cache hit
            if(cache.contains(city)) {
                // Cache 갱신, 최근으로 업데이트
                cache.remove(city);
                cache.add(city);
                time += 1;
            } else { 
                // Cache miss
                if(cache.size() == cacheSize) {
                    // 맨앞 도시 삭제 후 추가
                    cache.remove(0);
                    cache.add(city);
                }
                else
                    cache.add(city);
                
                time += 5; 
            }
            
        }
        
        return time;
    }
}