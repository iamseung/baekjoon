import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int V = Integer.parseInt(br.readLine());
		int i = 2;

		while (true) {
			if (V % i == 0) {
				V = V / i;
				sb.append(i + "\n");
				i = 1;
			}

			if (V == 1) {
				break;
			}
			i++;
		}

		System.out.println(sb);
	}
}