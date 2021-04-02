package bj11729;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        bw.write(((int)Math.pow(2, n) - 1) +"\n");

        hanoi(n, "1", "3", "2");

        bw.flush();
        bw.close();

    }

    public static void hanoi(int n, String start, String dest, String assist) throws IOException {
        if(n==1)
        {
            bw.write(start+" "+dest+"\n");
            return;
        }
        else
        {
            hanoi(n-1, start, assist, dest);
            bw.write(start+" "+dest+"\n");
            hanoi(n-1, assist, dest, start);
        }
    }
}
