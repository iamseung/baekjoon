class Solution {
    public int solution(int n) {
        int answer = (n % 2 == 0) ? n : n-1;
        return (answer/2) * (2 + answer) / 2;
    }
}