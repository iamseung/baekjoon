import java.util.*;
import java.io.*;

class Main
{
    static int[] N;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = new int[3];
        for(int i=0; i<3; i++) N[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(N);

        System.out.println(N[1]);

    }
}