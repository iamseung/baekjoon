import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int index = 1;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            pro();
        }

        System.out.println(sb.toString());
    }

    static void pro() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();

        while(st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        double t = arr.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);

        sb.append("#" + index++ + " " + Math.round(t) + "\n");
    }
}
