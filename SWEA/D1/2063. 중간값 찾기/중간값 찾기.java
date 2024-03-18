import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws Exception {
        pro();

        System.out.println(sb.toString());
    }

    static void pro() throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        sb.append(arr[N/2]);
    }
}