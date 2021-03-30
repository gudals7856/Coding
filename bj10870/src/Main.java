package bj10870;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pib = new int[n+1];

        if(n == 0)
            pib[n] = 0;

        else if(n == 1)
            pib[n] = 1;

        else
        {
            pib[0] = 0;
            pib[1] = 1;
            for(int i=2; i<n+1; i++)
                pib[i] = pib[i-1] + pib[i-2];
        }
        bw.write(Integer.toString(pib[n]));
        bw.flush();
        bw.close();
    }
}