import java.io.*;
import java.util.*;

class Solution
{
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

        int t = arr.stream()
            .filter(i-> i%2 != 0)
            .mapToInt(i->i)
            .sum();

        sb.append("#" + index++ + " " + t + "\n");
    }
}