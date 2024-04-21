import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
                    .filter(i -> i > height)
                    .count();
    }
}