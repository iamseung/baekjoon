import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = -101;
		int min = 101;
		int count = 0;
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > max) {
				max = num;
				count = i;
			}
			if (min < min) {
				min = num;
			}
		}
		System.out.println(max + "\n" + (count + 1));
	}
}