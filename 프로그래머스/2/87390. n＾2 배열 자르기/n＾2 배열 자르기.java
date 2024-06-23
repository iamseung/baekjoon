import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();

        for(long i=left; i <=right; i++) {
            long d = Math.max(i/n,i%n) + 1;
            list.add(d);
        }

        return list.stream()
                    .mapToInt(Long::intValue)
                    .toArray();
    }
}