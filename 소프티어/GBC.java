package DEBUG;

import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static int[] speedLimit = new int[101];
    static List<int[]> testData = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 제한속도 입력
        M = Integer.parseInt(st.nextToken()); // 광우의 테스트 구간

        int index = 0;

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int dis = Integer.parseInt(st.nextToken()) + index;
            int speed = Integer.parseInt(st.nextToken());

            while (index++ < dis) {
                speedLimit[index] = speed;
            }

            index--;
        }

        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            testData.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
    }
    
    static void process() {
        int index = 0, ANS = 0;

        for(int[] data : testData) {
            int dis = data[0] + index;
            int speed = data[1];

            while (index++ < dis) {
                if(speedLimit[index] < speed) {
                    ANS = Math.max(speed - speedLimit[index], ANS);
                }
            }

            index--;
        }

        System.out.println(ANS);
    }   
}