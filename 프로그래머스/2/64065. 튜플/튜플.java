import java.util.*;
import java.util.stream.*;

class Solution {
    static boolean[] num = new boolean[1000001];
    
    public int[] solution(String s) {
        // 1. 외부 중괄호 제거
        s = s.substring(1, s.length() - 1);

        // 2. 내부 중괄호 기준으로 분할
        String[] subsets = s.split("},\\{");
        int[][] result = new int[subsets.length][];

        for (int i = 0; i < subsets.length; i++) {
            // 3. 중괄호 제거 및 숫자로 분할
            String[] numbers = subsets[i].replaceAll("[{}]", "").split(",");

            // 4. 숫자 배열 생성
            result[i] = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                result[i][j] = Integer.parseInt(numbers[j].trim());
            }
        }

        // 길이 순으로 정렬
        Arrays.sort(result, (o1, o2)->(o1.length - o2.length));

        List<Integer> ans = new ArrayList<>();

        for(int[] a : result) {
            for(int b : a) {
                if(!num[b]) {
                    ans.add(b);
                    num[b] = true;
                }
            }
        }
            
        return ans.stream().mapToInt(i->i).toArray();
    }
}