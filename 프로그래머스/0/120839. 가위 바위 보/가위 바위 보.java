class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        for(char r : rsp.toCharArray())
            answer += towin(r);
        return answer;
    }
    
    private String towin(char i) {
        String a = "";
        switch(i) {
            case '2' : a = "0";
                break;
            case '0' : a = "5";
                break;
            case '5' : a = "2";
                break;
            default:
                break;
        }
        return a;
    }
}