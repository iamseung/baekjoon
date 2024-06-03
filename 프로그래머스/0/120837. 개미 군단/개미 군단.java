class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] ans = new int[]{5,3,1};
        
        for(int a : ans) {
            answer += hp/a;
            hp %= a;
        }
        return answer;
    }
}