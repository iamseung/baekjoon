import java.util.*;

class Solution {
    public long solution(int[] weights) {
         long answer = 0;

        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();

        // 오름차순 정렬했으므로 무게가 같은 경우와 (2/3, 2/4, 3/4)일 때만 고려해 접근
        for(int i : weights) {
    		double a = i*1.0;           // 무게가 같은 경우
    		double b = (i*2.0)/3.0;     // 2/3인 경우
    		double c = (i*1.0)/2.0;     // 2/4인 경우
    		double d = (i*3.0)/4.0;     // 3/4인 경우

    		if(map.containsKey(a)) answer += map.get(a);
    		if(map.containsKey(b)) answer += map.get(b);
    		if(map.containsKey(c)) answer += map.get(c);
    		if(map.containsKey(d)) answer += map.get(d);

    		map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
        }
        
        return answer;
    }
}