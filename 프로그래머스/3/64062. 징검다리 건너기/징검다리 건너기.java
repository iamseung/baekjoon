class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int L = 1;
        int R = 200000000;

        while(L<=R) {
            int mid = (L + R) / 2;

            if(canCross(stones, k, mid)) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return answer;
    }
    
    static boolean canCross(int[] stones, int k, int mid) {
        int skip = 0;

        for(int stone : stones) {
            if(stone - mid < 0) {
                skip++;
            } else {
                skip = 0;
            }

            // 연속으로 건널 수 없는 다리가 k 개만큼 나온 경우 건널 수 없다고 판별
            if(skip == k)
                return false;
        }

        return true;
    }
}