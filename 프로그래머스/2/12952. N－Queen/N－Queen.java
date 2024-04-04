class Solution {
    static int cnt = 0;
    static int[] Ches;
    
    public int solution(int n) {
        Ches = new int[n+1];
        rec(1, n);
        return cnt;
    }
    
    static void rec(int K, int N) {
        if(K == N+1) {
            cnt++;
            return;
        } else {
            // y열
            for(int y=1; y<=N; y++) {
                boolean possible = true;
                // x열
                for(int x=1; x<K; x++) {
                    if(!attackable(K, y, x, Ches[x])) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    // Ches[x] = y
                    Ches[K] = y;
                    rec(K+1, N);
                    Ches[K] = 0;
                }
            }
        }
    }

    // 좌표를 찍을 때 공격 가능 여부를 확인, (r1,c1) (r2,c2)
    static boolean attackable(int r1, int c1, int r2, int c2) {        
        if(c1 == c2) return false; // 같은 y열
        if(r1-c1 == r2-c2) return false; // 왼쪽 대각선
        if(r1+c1 == r2+c2) return false; // 오른쪽 대각선
        return true;
    }
}