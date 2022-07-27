import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append("Case #" + (i + 1) + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
			sb.append('\n');
		}
		System.out.println(sb);
	}
}