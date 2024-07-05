import java.util.*;

class Solution {
    static Map<String, Boolean> wordsMap = new HashMap<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        wordsMap.put(words[0], true);

        for(int i=1; i<words.length; i++) {
            String A = words[i-1];
            String B = words[i];

            if(wordsMap.containsKey(B) || !isAvailable(A, B)) {
                answer = new int[]{i%n + 1,i/n + 1};
                break;
            }

            wordsMap.put(words[i], true);
        }

        return answer;
    }
    
    static boolean isAvailable(String A, String B) {
        return A.charAt(A.length()-1) == B.charAt(0);
    }
}