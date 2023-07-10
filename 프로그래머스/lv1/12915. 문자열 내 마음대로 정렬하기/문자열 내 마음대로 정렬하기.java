import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        
        // 두번째 글자를 맨 앞에 붙인 string 을 가공
		for(int i=0; i<strings.length; i++) 
            list.add(strings[i].charAt(n) + strings[i]);
		// 정렬
		Collections.sort(list);
		// 1번째부터 subString
		for(int i=0; i<strings.length; i++)  
            strings[i] = list.get(i).substring(1);
        return strings;
    }
}