import java.io.*;
import java.util.*;

/*
 * 서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것
 * 종료시간을 기준으로 정렬
 */
public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] time;

    static void input() 
    {
        N = scan.nextInt();
        time = new int[N+1][2];

        for(int i=1; i<=N; i++) 
        {
            time[i][0] = scan.nextInt(); // 시작시간
            time[i][1] = scan.nextInt(); // 종료시간
        }

        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의 
		Arrays.sort(time, new Comparator<int[]>() {	
			@Override
			public int compare(int[] o1, int[] o2) 
            {	
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.[오름차순]
				if(o1[1] == o2[1]) return o1[0] - o2[0];

				return o1[1] - o2[1];
			}
		});
    }

    static void pro() 
    {
        int count = 0;
		int prev_end_time = 0;
		
		for(int i = 1; i <= N; i++) 
        {
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= time[i][0]) 
            {
                // 직전 종료시간을 해당 회의 종료 시간으로 갱신! & count++
				prev_end_time = time[i][1];
				count++;
			}
		}

        System.out.println(count);        
    }

    public static void main(String[] args) 
    {
        input();
        pro();
    }


    static class FastReader 
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) 
            {
                try{
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}