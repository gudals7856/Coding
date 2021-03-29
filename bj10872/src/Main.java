package bj10872;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mul = 1;

        if(n == 0)
        {
            bw.write('1');
            bw.flush();
            bw.close();
            return;
        }
        else
        {
            for(int i=n; i>0; i--)
            {
                mul *= i;
            }
            bw.write(Integer.toString(mul));
            bw.flush();
            bw.close();
        }
    }
}
