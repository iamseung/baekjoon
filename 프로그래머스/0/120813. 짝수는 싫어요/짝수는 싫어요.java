import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        return IntStream.rangeClosed(1, n)
                    .filter(i->i%2==1)
                    .map(i-> i)
                    .toArray();
    }
}