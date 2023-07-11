import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = Arrays.stream(arr)
            .mapToDouble(i->i)
            .sum();
        return answer/arr.length;
    }
}