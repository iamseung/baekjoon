import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);
    }

    static void process() {
        int answer = 4;
        int tmp;
        for (int item : list) {
            tmp = 0;
            for (int j = item + 1; j < item + 5; j++) {
                // 없는 경우
                if (Collections.binarySearch(list, j) < 0)
                    tmp++;
            }
            answer = Math.min(answer, tmp);
        }

        System.out.println(answer);
    }
}