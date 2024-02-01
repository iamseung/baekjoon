import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M, N, K;
    static StringBuilder mlist = new StringBuilder();
    static StringBuilder nlist = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 비밀 메뉴 조작법
        N = Integer.parseInt(st.nextToken()); // 사용자의 버튼 조작
        K = Integer.parseInt(st.nextToken()); // 버튼 수의 범위

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            mlist.append(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
            nlist.append(st.nextToken());
        } 
    }
    
    static void process() {
        String ANS = "";
        if(N < M){
           ANS = "normal";
        } else{
           ANS = (nlist.toString().contains(mlist.toString())) ? "secret" : "normal";
        }

        System.out.println(ANS);
    }   
}