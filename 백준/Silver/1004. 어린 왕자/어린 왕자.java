import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main 
{
	public static int T = 0;
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int P = Integer.parseInt(br.readLine());

		while(P-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");

			// 좌표들
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 횟수
			int S = 0;
			
			// 행성의 갯수
			int N = Integer.parseInt(br.readLine());

			while(N-- >0)
			{
				// 출발점이 현재 행성의 안에 있는지 밖에 있는지 여부
                boolean check1 = false;
                // 도착점이 현재 행성의 안에 있는지 밖에 있는지 여부
                boolean check2 = false;

				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				
				// 시작점이 행성의 밖에 있으면 true
                if(Math.pow(x1 - X, 2) + Math.pow(y1 - Y, 2) > Math.pow(R, 2)) check1 = true;
                // 도착점이 행성의 밖에 있으면 true
                if(Math.pow(x2 - X, 2) + Math.pow(y2 - Y, 2) > Math.pow(R, 2)) check2 = true;

				// 시작점, 도착점 둘 중에 하나만 행성안에 있고 다른점은 밖에 있는 경우
                if(check1 == true && check2 == false) S++;
                else if(check1 == false && check2 == true) S++;
			}
			System.out.println(S);
		}
		
	}	
}
