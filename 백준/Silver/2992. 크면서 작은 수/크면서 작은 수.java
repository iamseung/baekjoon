import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int A,len,min = Integer.MAX_VALUE;
    static int[] numbers = new int[10];
    static PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());

        String strA = String.valueOf(A);
        len = strA.length();

        for(char c : strA.toCharArray())
            numbers[c - '0']++;
    }

    public static void process(){
        backTracking(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    public static void backTracking(int depth, int num) {
        if(depth == len && num > A) {
            min = Math.min(min, num);
            return;
        }

        for(int i=0; i<=9; i++) {
            if(numbers[i] > 0) {
                // 첫자리에 0이 대입되는 경우를 제거
                if(num == 0 && i == 0) 
                    continue;

                numbers[i]--;
                backTracking(depth + 1, num * 10 + i);
                numbers[i]++;
            }
        }
    }
}