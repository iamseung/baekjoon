import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 최대값 확인을 위한 max 선언
		int max = 0;

		//3개의 카드를 고르기 때문에 첫 번째 카드는 n-2까지 순회
		for(int A=0; A<N-2; A++)
		{
			//두 번째 카드는 첫 번째 다음부터 n-1까지 순회
			for(int B=A+1; B<N-1; B++)
			{
				//세 번째 카드는 두 번째 카드 다음부터 n까지 순회
				for(int C=B+1; C<N; C++)
				{
					int sum = arr[A] + arr[B] + arr[C];
					
					//문제에서 3장의 합은 m보다 클수 없다고 했으니 합이 m보다 작을때만 계산
                    //3카드의 합보다 m이 더 크다면 Max와 sum중에 더 큰 값을 max에 대입
					if(sum <= S) max = Math.max(max, sum);

					//max == m이면 가장 가까운 합이므로 출력 후 종료
					if(max == S)
					{
						System.out.println(max);
						return;
					}					
				}
			}
		}
		System.out.println(max);
	}
}