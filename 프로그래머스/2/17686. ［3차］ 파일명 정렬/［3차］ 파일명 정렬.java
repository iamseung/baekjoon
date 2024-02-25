import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        return sortFiles(files);
    }
    
    public static String[] sortFiles(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // HEAD 추출
                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                
                // HEAD 비교
                int headCompare = head1.toLowerCase().compareTo(head2.toLowerCase());
                if (headCompare != 0) return headCompare;
                
                // NUMBER 추출, HEAD 를 제거
                String number1 = s1.substring(head1.length()).split("[^0-9]")[0];
                String number2 = s2.substring(head2.length()).split("[^0-9]")[0];
                
                // NUMBER 비교
                int num1 = Integer.parseInt(number1);
                int num2 = Integer.parseInt(number2);
                
                return Integer.compare(num1, num2);
            }
        });

        return files;
    }
}