import java.util.*;

class Solution {
    static final int multiply = 65536;
    
    public int solution(String str1, String str2) {
        //소문자 대문자 상관없기 때문에 소문자로 만들기
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //str1의 단어 리스트
        List<String> list1 = new ArrayList<>();

        //str2의 단어 리스트
        List<String> list2 = new ArrayList<>();

        //교집합 리스트
        List<String> intersection = new ArrayList<>();

        //합집합 리스트
        List<String> union = new ArrayList<>();

        //str1 두 단어씩 나눠서 list1 에 넣기
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (c1 >= 'a' && c1 <= 'z') {
                if (c2 >= 'a' && c2 <= 'z') {
                    list1.add(c1 + "" + c2);
                }
            }
        }

        for(String s : list1)
            System.out.println(s);
        //str2 두 단어씩 나눠서 list2 에 넣기
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (c1 >= 'a' && c1 <= 'z') {
                if (c2 >= 'a' && c2 <= 'z') {
                    list2.add(c1 + "" + c2);
                }
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for(String s : list1){
            if(list2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : list2){
            union.add(s);
        }

        double answer = 0;

        if(union.size() == 0) {
            answer = 1;
        } else {
            answer = (double) intersection.size() / (double) union.size();
        }

        return (int) (answer * multiply);
    }
}