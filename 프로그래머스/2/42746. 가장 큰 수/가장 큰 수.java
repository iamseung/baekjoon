import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] stringArray = Arrays.stream(numbers)
                                     .mapToObj(String::valueOf)
                                     .toArray(String[]::new);

        // 문자열 비교를 통해 정렬
        Arrays.sort(stringArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 두 문자열을 서로 붙여보며 큰 순서대로 정렬
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (stringArray[0].equals("0")) 
            return "0";

        for(String s : stringArray)
            answer += s;

        return answer;
    }
}