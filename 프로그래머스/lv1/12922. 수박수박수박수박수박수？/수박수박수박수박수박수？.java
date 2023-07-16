class Solution {
    StringBuilder sb = new StringBuilder();
    public String solution(int n) {
        int k = n/2;
        while(k-- >0) sb.append("수박");
        if(n%2 != 0) sb.append("수");
        
        return sb.toString();
    }
}