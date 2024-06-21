class Solution {
    public int solution(int n) {
        // 1의 개수 확인
        int cnt = Integer.bitCount(n);
        
        while(true) {
            if(cnt == Integer.bitCount(++n)) break;
        }
        
        return n;
    }
}