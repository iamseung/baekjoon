package DEBUG;

import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int W, N;
    static List<int[]> jew = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 배낭의 무게
        N = Integer.parseInt(st.nextToken()); // 귀금속의 종류

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            // 0 : 금속의 무게
            // 1 : 무게당 가격
            jew.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
    }
    
    static void process() {
        // 기준점에 맞게 정렬
        Collections.sort(jew, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 무게당 가격이 같으면 금속의 무게가 작은 것부터
                if(o2[1] == o1[1]) {
                    return o1[0] - o2[0];
                }
                // 무게당 가격이 큰거부터
                return o2[1] - o1[1];
            }
        });

        /*
         * 100 2
            90 1
            70 2
         */
        int ANS = 0;
        for(int[] j : jew) {
            // 가방에 다 넣을 수 있는 경우
            if(W >= j[0]) {
                ANS += j[0] * j[1];
                W -= j[0];
            } else {
                // 다 못 넣는 경우, 가방의 남은 용량만큼
                ANS += W * j[1];
                break;
            }
        }

        System.out.println(ANS);
    }   
}