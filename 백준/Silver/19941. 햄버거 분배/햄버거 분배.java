import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K;
    static String input;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = br.readLine(); // P 사람, H 햄버거

        process();
    }

     public static void process() {
        boolean[] visited = new boolean[N];
        int answer = 0;
        char[] arr = input.toCharArray();

        for(int i=0; i<N; i++) {
            // 사람의 경우
            if(arr[i] == 'P') {
                for(int j= -K; j <= K; j++) {
                    int next = i+j;

                    if(next >= N) break; // 범위 초과
                    if(next < 0) continue; // 예외 처리

                    // 먹지 않은 햄버거일 경우
                    if(arr[next] == 'H' && !visited[next]) {
                        visited[next] = true;
                        answer += 1;
                        break;
                    }
                }
            }
        }

         System.out.println(answer);
     }
}
