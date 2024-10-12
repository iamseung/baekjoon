import java.io.*;
import java.util.*;

public class Main {

	static int N, S, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[2]);

		arr = new int[M + 1];

		for (int i = 0; i <= M; i++) {
			arr[i] = -1;
		}
        
		arr[S] = 0;

		input = br.readLine().split(" ");

		for (int i = 1; i <= N; i++) {
			int V = Integer.parseInt(input[i - 1]);
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j <= M; j++) {
				if (arr[j] == i - 1) { // i-1번째에서 가능한 볼륨들을 찾는다.
					int res1 = j + V;
					int res2 = j - V;

					if (0 <= res1 && res1 <= M)
						list.add(res1);
					if (0 <= res2 && res2 <= M)
						list.add(res2);
				}
			}
			
			for (int n : list) {
				arr[n] = i;
			}
		}

		int max = -1;
		for (int i = 0; i <= M; i++) {
			if (arr[i] == N)
				max = Math.max(max, i);
		}

		bw.write(max + "\n");
		bw.flush();

	}

}