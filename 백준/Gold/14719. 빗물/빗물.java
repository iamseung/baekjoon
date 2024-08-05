import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int H, W;
    static int[][] area;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken()); // 높이
        W = Integer.parseInt(st.nextToken()); // 길이

        area = new int[H][W];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<W; i++) {
            int k = Integer.parseInt(st.nextToken());

            for(int l=0; l<k; l++) {
                area[l][i] = 1;
            }
        }
    }

    static void process() {
        int sum = 0;
        // 높이마다 변환
        for(int i=0; i<H; i++) {
            // 벽인 부분을 찾는 stream
            final int finalI = i;
            int bIndex = IntStream.range(0, area[finalI].length) // 각 행의 모든 인덱스에 대해 스트림 생성
                .filter(j -> area[finalI][j] == 1)
                .findFirst()
                .orElse(-1);

            if(bIndex != -1 && bIndex+1 < W) {
                for(int j=bIndex+1; j<W; j++) {
                    // 벽인 경우
                    if(area[i][j] == 1) {
                        // 빗물이 고일 수 있는 환경
                        if(j - bIndex > 1) {
                            sum += j - bIndex - 1;
                        }
    
                        bIndex = j;
                    }

                    // 벽을 만나지 않은 경우엔 index 유지
                }
            }
        }

        System.out.println(sum);
    }
}