import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] tail = new int[N+1];
        List<Integer> ans = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) 
            tail[i] = Integer.parseInt(st.nextToken());

        for(int i=N; i>=1; i--)
            // key, value
            ans.add(tail[i], i);

        for(int a : ans)
            System.out.print(a+" ");
	}
}
