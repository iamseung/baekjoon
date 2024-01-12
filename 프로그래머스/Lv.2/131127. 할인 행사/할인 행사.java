import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 원하는 물품과 수량 매핑
        Map<String, Integer> wantMap = new HashMap<String, Integer>();
        
        for(int i=0; i<want.length; i++)
            wantMap.put(want[i], number[i]);
        
        // 10일간 할인물품 비교
        for(int j=0; j<discount.length - 9; j++){                 
            int idx = 0;
            Map<String, Integer> disCountMap = new HashMap<String, Integer>();
            
            // 할인 물품, 수량 매핑
            for(int i=0; i<10; i++)
                disCountMap.put(discount[i+j], disCountMap.getOrDefault(discount[i+j], 0) + 1);
            // 1. 할인물품이 구매하고자 하는 물품을 할인하고
            // 2. 할인물품의 수량이 구매하고자 하는 물품의 수량보다 많거나 같으면
            for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
                if(disCountMap.containsKey(entry.getKey()) && 
                   entry.getValue()<=disCountMap.get(entry.getKey())) {
                    idx++;
                } 
            }

            if(idx == want.length)
                answer++;
        }

        return answer;
    }
}