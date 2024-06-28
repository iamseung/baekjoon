import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        List<Integer> ans = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Integer.parseInt(br.readLine());

        while(cnt-- >0) {
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;

            for(int i=y1; i<=y2; i++) {
                for(int j=x1; j<=x2; j++)
                    sum += arr[i][j];
            }
            
            ans.add(sum);
        }

        for(int a : ans) 
            System.out.println(a);
    }
}