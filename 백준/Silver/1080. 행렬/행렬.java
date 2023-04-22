import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int row, col, cnt;
    static int[][] A, B;

    static void input() 
    {
        row = scan.nextInt(); col = scan.nextInt();
        A = new int [row][col]; B = new int [row][col];

        // A
		for(int i=0 ; i<row; i++) 
        {
			String str = scan.nextLine();
			for(int j=0 ; j<col; j++) A[i][j] = Integer.parseInt(str.substring(j,j+1));
		}

        // B
		for(int i=0 ; i<row; i++) 
        {
			String str = scan.next();
			for(int j=0 ; j<col; j++) B[i][j] = Integer.parseInt(str.substring(j,j+1));
		}
    }

    static void pro() 
    {
        cnt = 0;
        
		//탐색 시작(배열 범위 넘어가지않게 row-2 , col-2 까지만 돌림
		for(int i=0 ; i<row-2; i++) 
        {
			for(int j=0 ; j<col-2; j++) 
            {
				// i,j 가 다르다면 뒤집는다(이 지점은 다시뒤집을수 없는 지점이므로 무조건 뒤집음)
				if(A[i][j] != B[i][j]) 
                {
					change(i,j);
					cnt++;
				}
			}
		}

        //A,B배열이 같은지 확인
		for(int i = 0 ; i < row ; i++) 
        {
			for(int j = 0 ; j < col ; j++) 
            {
				if(A[i][j] != B[i][j])
                {
                    System.out.println(-1);
                    return;        
                }
			}
		}

        System.out.println(cnt);
    }

    //i,j 기준으로 3*3 크기만큼 비트 뒤집기
	public static void change(int x , int y) 
    {
		for(int i = x ; i <x+3 ; i++) 
        {
			for(int j = y; j<y+3 ; j++) A[i][j] ^= 1 ;
		}
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

        public FastReader() 
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException 
        {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() 
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
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

        String nextLine() 
        {
            String str = "";
            try 
            {
                str = br.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}