class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >=a)
        {
            // 총 개수 n 에서 a 병당 b명을 제공
            answer += n/a*b;
            n = n/a*b + n%a;
        }
    
        return answer;
    }
}