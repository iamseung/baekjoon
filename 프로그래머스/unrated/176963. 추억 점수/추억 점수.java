import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> hashMap = new HashMap<>();
        for(int i=0; i<name.length; i++)
            hashMap.put(name[i], yearning[i]);
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                if (hashMap.containsKey(photo[i][j]))
                    sum += (int)hashMap.get(photo[i][j]);
            }
            answer[i] = sum;
        }
        return answer;
    }
}