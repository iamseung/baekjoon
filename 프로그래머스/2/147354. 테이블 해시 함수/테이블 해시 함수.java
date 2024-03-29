import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        final int coll = col - 1;
        row_begin -= 1;
        row_end -= 1;

        // col 기존 오름차순
        Arrays.sort(data, (e1, e2) -> {
            if(e1[coll] == e2[coll]) return e2[0] - e1[0];
            return e1[coll] - e2[coll];
        });

        List<Integer> list = new ArrayList<>();
        for(int i = row_begin; i <= row_end; i++) {
            final int index = i;            
            int temp = Arrays.stream(data[i])
                        .boxed()
                        .mapToInt(k -> k%(index+1))
                        .sum();
            
            list.add(temp);
        }

        int xorResultStream = list.stream()
        .reduce(0, (a, b) -> a ^ b); // 초기값 0, 두 요소를 XOR 연산

        return xorResultStream;
    }
}