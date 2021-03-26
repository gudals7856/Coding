package bj2675;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());	// 테스트케이스의 개수

        String[] s = new String[n];		// 입력할 테스트케이스
        String[] num = new String[n];	// 테스트 케이스에서 반복횟수의 string형
        int[] R = new int[n];			// 반복횟수의 int형
        String[] S = new String[n];		// 반복시킬 문자열

        for(int i=0; i<n; i++)
            s[i] = br.readLine();


        for(int i=0; i<n; i++)
        {
            num[i] = s[i].split(" ")[0];
            R[i] = Integer.parseInt(num[i]);   // 반복 횟수 R
            S[i] = s[i].split(" ")[1];	// 반복시킬 문자열 S
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<S[i].length(); j++)
            {
                for(int k=0; k<R[i]; k++)
                {
                    char result = S[i].charAt(j);
                    bw.write(Character.toString(result));
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
