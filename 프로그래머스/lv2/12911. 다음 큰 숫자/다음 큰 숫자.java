class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n); // 1의 개수 확인
        
        while(true) {
            if(cnt == Integer.bitCount(++n)) break;
        }
        
        return n;
    }
}