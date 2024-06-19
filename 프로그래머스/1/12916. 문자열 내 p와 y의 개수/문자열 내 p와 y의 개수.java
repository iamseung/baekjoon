class Solution {
    boolean solution(String s) {
        int cnt = 0;
        s = s.toUpperCase();
        for(char c : s.toCharArray()) {
            if(c == 'P')
                cnt++;
            if(c == 'Y')
                cnt--;
        }

        return (cnt == 0) ? true : false;
    }
}