import java.util.*;
import java.io.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K;
    static char[] chart;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chart = new char[N];
        chart = br.readLine().toCharArray();

        visited = new boolean[N];
    }

    static void process() {
        for(int i=0; i<N; i++) {
            if(chart[i] == 'P') { //사람을 만났다면, K인 것 앞에서부터
    			for(int j = -K; j <= K; j++) {
    				if(i + j >= N) break;
    				if(i + j < 0) continue;
    				
    				if(chart[i+j] == 'H' && !visited[i+j]) {
    					visited[i+j] = true;
    					answer += 1;
    					break;
    				}
    			}
    		}
        }

        System.out.println(answer);
    }
}