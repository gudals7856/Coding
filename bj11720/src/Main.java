package bj11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();
        
        int s = sum(n, num);

        bw.write(Integer.toString(s));
        bw.flush();
        bw.close();
    }

    public static int sum(int n, String num) {
        int s = 0;
        int ctoi;
        for(int i=0; i<n; i++)
        {
            char c = num.charAt(i);
            ctoi = Character.getNumericValue(c);
            s += ctoi;
        }
        return s;
    }
}
