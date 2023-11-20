import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N, max;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());
        while(T-->0) {
            input();
            process();
        }

        System.out.println(sb.toString());
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            // 배열 생성
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        long ANS = 0, max = arr[N-1];
        
        // 역방향 조회
        for(int i=N-2; i>=0; i--) {
            // 최대값 보다 같거나 작을 경우 수익을 낸다. (같은 경우, max == arr[i] => 0)
            if(arr[i] <= max) {
                ANS += max - arr[i];
            }
            // 최대값 갱신
            else {
                max = arr[i];
            }
        }

        sb.append(ANS+"\n");
    }
}