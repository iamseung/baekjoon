import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);

        int index = 1, max = 0;
        while(true) {
            max = arr[arr.length-1] * index++;

            boolean is = true;
            for(int i=0;i<arr.length-1;i++) {
                if(max % arr[i] != 0)
                    is = false;
            }

            if(is)
                break;
        }
        
        return max;
    }
}