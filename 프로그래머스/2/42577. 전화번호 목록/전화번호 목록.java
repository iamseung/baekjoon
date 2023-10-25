import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 숫자 오름차순 -> 길이 오름차순
        Arrays.sort(phone_book);
        
        // 앞 번호가 뒷 번호의 접두어인지 체크
        for(int i=0; i<phone_book.length -1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}