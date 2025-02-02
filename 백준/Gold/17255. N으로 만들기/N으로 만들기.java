import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] input;
    static int len;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        input = br.readLine().toCharArray();
    }

    static void process() {
        len = input.length;
        for (int i = 0; i < len; i++)
            dfs(i, i, String.valueOf(input[i]), String.valueOf(input[i]));

        System.out.println(set.size());
    }

    static void dfs(int L, int R, String s, String path) {
        // 양 끝까지 확장 완료
        if (L == 0 && R == len - 1) {
            set.add(path);
            return;
        }

        // 좌측으로 확장
        if (L - 1 >= 0)
            dfs(L - 1, R, input[L - 1] + s, path + " " + input[L - 1] + s);

        // 우측으로 확장
        if (R + 1 < len)
            dfs(L, R + 1, s + input[R + 1], path + " " + s + input[R + 1]);
    }
}