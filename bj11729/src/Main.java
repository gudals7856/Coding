package bj11729;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String process = "";
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        bw.write(((int)Math.pow(2, n) - 1) +"\n");

        hanoi(n, "1", "3", "2");
        bw.write(count+"\n");
        bw.write(process);

        bw.flush();
        bw.close();

    }

    public static void hanoi(int n, String start, String dest, String assist) throws IOException {
        if(n==1)
        {
            process += start + " " + dest + "\n";
            count++;
            return;
        }
        else
        {
            // STEP 1 : N-1개를 A에서 B로 이동
            hanoi(n-1, start, assist, dest);

            // STEP 2 : 가장 큰 원판 1개를 A에서 C로 이동
            process += start + " " + dest + "\n";
            count++;

            // STEP 3 : N-1개를 B에서 C로 이동
            hanoi(n-1, assist, dest, start);
        }
    }
}
