import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> list = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>(list);
        
        Collections.sort(arr);
        
        int[] answer = arr.stream()
            .mapToInt(i->i)
            .toArray();
            
        return answer;
    }
}