import java.util.*;

class Solution {
    static Map<String, Integer> dic = new HashMap<>();
    static int index = 1;
    
    public int[] solution(String msg) {
        init();
        
        List<Integer> ANS = new ArrayList<>();
        
        for(int k=0; k<msg.length(); k++) {
            // 찾을 문자열
            String compare = String.valueOf(msg.charAt(k));

            // 다음 문자까지 더한 문자가 사전이 있는 경우, 문자 늘리면서 있는지 참조
            while(k+1 < msg.length() && dic.containsKey(compare+""+msg.charAt(k+1))) {
                compare += String.valueOf(msg.charAt(++k));
            }            

            // 사전 색인 번호 입력
            ANS.add(dic.getOrDefault(compare, index));
            
            // 사전 추가
            if((k+1 >= msg.length())) {
                break;
            }

            String next = compare+""+msg.charAt(k+1);
            dic.put(next, index++);
        }
        
        return ANS.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    static void init() {
        for(char c = 'A'; c <= 'Z'; c++) 
            dic.put(String.valueOf(c), index++);
    }
}