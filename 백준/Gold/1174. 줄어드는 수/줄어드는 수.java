import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int [] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void process(){
        dfs(0L, 0);
        Collections.sort(list);

        try {
            System.out.println(list.get(N-1));
        } catch(Exception e) {
            System.out.println(-1);
        }
    }

    // 가장 큰 감소하는 수, 9_876_543_210
    public static void dfs(long num, int idx) {
        if(!list.contains(num))
            list.add(num);

        // 10 자리를 넘어가는 경우 감소하는 수가 될 수 없음
        if(idx >= 10)
            return;

        // 현재 수를 선택하는 경우
        dfs((num * 10) + arr[idx], idx+1);

        // 현재 수를 선택하지 않는 경우
        dfs(num, idx+1);
    }
}