import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Integer[] dp;
    static int[][] wire;

    public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

        dp = new Integer[N];
        wire = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken()); // A 전봇대
            wire[i][1] = Integer.parseInt(st.nextToken()); // B 전봇대
        }

        // A 전봇대를 기준으로 오름차순 정렬
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        // 두 전봇대 사이에 전선을 연결할 때, 전선이 교차하지 않게 하면서 설치할 수 있는 전선의 최대 개수를 찾는 것
        // i번째 A전봇대를 기준으로 연결가능한 개수 탐색 & 최댓값 찾기
        for(int i=0; i<N; i++)
            max = Math.max(max, recur(i));

        // 전선 개수 - 최대값
        System.out.println(N-max);
       
	}

    static int recur(int K) {
        // 탐색하지 않은 위치라면
        if(dp[K] == null) {
            // 최솟 값 초기화
            dp[K] = 1;

            // A의 K번째와 이후의 전봇대들 비교
            for(int i=K+1; i<N; i++) {
                /*
                 * A전봇대의 K번째 전선이 연결되어있는 B 전봇대보다 
                 * A의 i번째 전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우
                 * 전선을 설치할 수 있음을 의미, 최대값 갱신
                 */
                if(wire[K][1] < wire[i][1]) {
                    dp[K] = Math.max(dp[K], recur(i) + 1);
                }
            }
        }

        return dp[K];
    }
}