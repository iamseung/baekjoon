import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        double answer = Arrays.stream(numbers)
            .mapToDouble(i->i)
            .sum();
        return answer/numbers.length;
    }
}