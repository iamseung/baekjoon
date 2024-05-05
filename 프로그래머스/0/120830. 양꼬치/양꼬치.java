class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        return n*12000 + (k - (n/10)) * 2000;
    }
}