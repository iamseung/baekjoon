import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int max = Arrays.stream(tangerine).max().getAsInt();
        // index : 종류 , value : 수량
        int[] arr = new int[max+1];
        for(int t : tangerine)
            arr[t]++;
        
        List<Integer> list = new ArrayList<>();
        for(int a : arr)
            list.add(a);

        // 개수 많은 순으로 정렬
        Collections.sort(list, ((o1, o2) -> (o2 - o1)));
        
        int index = 0;
        for(int l : list) {
            if(k-l <= 0)
                break;

            k -= l;
            index++;
        }
        
        return index + 1;
    }
}