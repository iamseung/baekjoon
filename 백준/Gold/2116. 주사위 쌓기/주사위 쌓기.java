import java.io.*;
import java.util.*;

public class Main {
    static int max = -1, N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][6];
        //N개의 주사위 정보 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<6;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        //1번째 주사위 상태에 따른 재귀 탐색 진행
        for(int i=0;i<6;i++) {
            search(1, i, 0);
        }
        bw.write(String.valueOf(max));	//최대값 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //주사위를 순차적으로 쌓는 재귀 함수
    static void search(int cnt, int bottom, int sum){
        //아랫면을 마주보는 면 구하기
        int pair = pairCheck(bottom);
        int tempMax = -1;
        //옆면의 최대값 구하기
        for(int i=0;i<6;i++){
            if(i == pair || i == bottom)
                continue;
            tempMax = Math.max(tempMax, arr[cnt-1][i]);
        }
        sum += tempMax;	//최대값 더하기
        //주사위를 모두 다 쌓았을 때
        if(cnt == N){
            max = Math.max(max, sum);	//최대값 비교
            return;
        }
        //다음 주사위 쌓기 진행
        for(int i=0;i<6;i++){
            if(arr[cnt-1][pair] == arr[cnt][i]){
                search(cnt+1, i, sum);
                break;
            }
        }
    }
    //마주보는 면 인덱스 구하는 함수
    static int pairCheck(int n){
        if(n == 0)
            return 5;
        else if(n == 1)
            return 3;
        else if(n == 2)
            return 4;
        else if(n == 3)
            return 1;
        else if(n == 4)
            return 2;
        else
            return 0;
    }
}