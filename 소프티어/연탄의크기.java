import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int N;
    
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }
    
    static void process() {
        Arrays.sort(arr);

        int ANS = 0;
        // 2, 5, 5 가 주어졌을 때 마지막 사이즈가 정답인 반례가 존재, 범위 주의
        for(int i=2; i<=arr[N-1]; i++) {
            int CNT = 0;
            for(int j=0; j<N; j++) {
                if(arr[j] % i == 0) CNT++;
            }
            ANS = Math.max(CNT, ANS);
        }
        System.out.println(ANS);
    }
}