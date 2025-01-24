import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, minGuitarCount = Integer.MAX_VALUE;
    static int max = 0;
    //기타 연주 가능 목록 비트마스킹 배열
    static long[] guitarBit;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitarBit = new long[N];
        //입력값 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            st.nextToken();
            char[] guitarTF = st.nextToken().toCharArray();
            //'Y' = 1, 'N' = 0 비트 형태로 변경
            for(int j=0;j<M;j++){
                if (guitarTF[j] == 'Y') {
                    guitarBit[i] |= (1L<<j);
                }
            }
        }
        //백트래킹을 통해서 탐색 진행
        search(0,  0L, 0);
        //연주할 수 있는 곡이 없을 때
        if (minGuitarCount == 0) {
            minGuitarCount = -1;
        }
        //기타의 개수 BufferedWriter 저장
        bw.write(String.valueOf(minGuitarCount));
        bw.flush();
        bw.close();
        br.close();
    }
    //백트래킹을 통해서 기타 연주 여부를 기준으로 탐색합니다.
    static void search(int idx, long guitarMask, int val){
        //현재 연주 가능한 곡의 개수
        int bitCount = Long.bitCount(guitarMask);

       
        //현재 최대값은 같지만, 사용한 기타의 수가 더 작을 때
        if(bitCount == max && val < minGuitarCount) {
            minGuitarCount = val;
        }
        //현재 최대값보다 더 많은 곡을 칠 수 있을 때
        if(bitCount > max) {
            minGuitarCount = val;
            max = bitCount;
        }
        //모든 곡을 칠 때, 모든 기타를 확인했을 때
        if(bitCount == M || idx == N){
            return;
        }

        //현재 기타를 사용할 때
        search(idx+1, guitarMask | guitarBit[idx], val+1);
        //현재 기타를 사용하지 않을 때
        search(idx+1, guitarMask, val);

    }
}