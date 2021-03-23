package bj10809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alp =  new int[26];

        for(int i=0; i<26; i++)
        {
            for(int j=0; j<str.length(); j++)
            {
                if(str.charAt(j) == 'a' + i)
                {
                    alp[i] = j;
                    break;
                }
                else
                    alp[i] = -1;
            }
        }
        for(int i=0; i<26; i++)
        {
            bw.write(Integer.toString(alp[i]) + ' ');
        }
        bw.flush();
        bw.close();
    }
}
