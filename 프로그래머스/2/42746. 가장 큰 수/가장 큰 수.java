import java.util.*;

class Solution {
    public String solution(int[] numbers) {
         String[] strNumbers = new String[numbers.length];
        
        // 정수 배열을 문자열 배열로 변환
        for (int i = 0; i < numbers.length; i++)
            strNumbers[i] = String.valueOf(numbers[i]);
        
        // 문자열 비교를 통해 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 두 문자열을 서로 붙여보며 큰 순서대로 정렬
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        // 정렬된 배열의 첫 번째 요소가 "0"이면, 모든 숫자가 0이므로 "0"을 반환
        if (strNumbers[0].equals("0")) 
            return "0";
        
        // 문자열 배열을 이어붙여 결과 문자열 생성
        StringBuilder sb = new StringBuilder();
        for (String num : strNumbers) 
            sb.append(num);
        
        return sb.toString();
    }
}