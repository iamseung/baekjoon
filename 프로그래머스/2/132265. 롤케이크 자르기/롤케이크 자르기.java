import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> origin = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for(int t : topping)
            origin.put(t, origin.getOrDefault(t, 0) + 1);

        for(int i = topping.length - 1; i>= 0; i--) {
            int key = topping[i];

            origin.put(key, origin.get(key) - 1);            
            
            if(origin.get(key) == 0)
                origin.remove(key);

            rightMap.put(key, rightMap.getOrDefault(key, 0) + 1);

            if(origin.size() == rightMap.size())
                answer++;
            
        }

        return answer;
    }
}