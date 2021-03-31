package bj2447;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] stars = new char[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                stars[i][j] = ' ';

        printstar(0,0,n,stars);

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
            {
                bw.write(stars[i][j]);
                if(j == n-1)
                    bw.write("\n");
            }
        bw.flush();
        bw.close();
    }

    public static void printstar(int i, int j, int n, char[][] stars) {
        int next = n/3;
        if(next == 0)
            stars[i][j] = '*';

        else
        {
            stars[i][j] = '*';
            printstar(i, j, next, stars);
            printstar(i, j+next, next, stars);
            printstar(i, j+next*2, next, stars);
            printstar(i+next, j, next, stars);
            printstar(i+next, j+next*2, next, stars);
            printstar(i+next*2, j, next, stars);
            printstar(i+next*2, j+next, next, stars);
            printstar(i+next*2, j+next*2, next, stars);
        }
    }
}
