class Solution {
    static boolean[] alpha = new boolean[26];
    public String solution(String s, String skip, int index) {
        makeSkip(skip); // skip 해야 할 알파벳 체크
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            answer += makeStr(s.charAt(i) -'a', index);
        }
        
        return answer;
    }
    
    static void makeSkip(String skip) {
        for(int i=0; i<skip.length(); i++) {
            alpha[skip.charAt(i) -'a'] = true;
        }
    }
    
    static String makeStr(int N, int index) {
        while(index-- > 0) {
            // skip
            if(N+1 >=26) N = -1;
            
            if(alpha[++N]) {
                index++;
                continue;
            }
        }
        
        return String.valueOf((char)(N+'a'));
    }
}