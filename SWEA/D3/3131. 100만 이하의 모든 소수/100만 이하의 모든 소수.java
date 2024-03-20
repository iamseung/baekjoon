import java.util.*;
import java.io.*;

public class Solution {
    
	public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
		
        boolean[] prime = new boolean[1000001];
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(prime.length); i++)
        {
            if(prime[i]) continue;

            for(int j = i * i; j < prime.length; j += i) 
            {
				prime[j] = true;
			}
        }

        for(int i=2; i<=1000000; i++) {
            if(!prime[i]) sb.append(i+" ");
        }
        
        System.out.println(sb.toString());

	}
}