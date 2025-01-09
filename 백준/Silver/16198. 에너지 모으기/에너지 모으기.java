import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Integer> arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr.add(Integer.parseInt(st.nextToken()));
    }

    public static void process(){
        dfs(arr, 0);
        System.out.println(max);
    }

    static void dfs(List<Integer> list, int sum) {
        if(arr.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        // 1번부터 N-1까지 탐색
        for(int i=1; i<list.size()-1; i++) {
            int temp = list.get(i);
            int chargeV = list.get(i-1) *  list.get(i+1);
            list.remove(i);
            dfs(list, sum + chargeV);
            list.add(i, temp);
        }
    }
}