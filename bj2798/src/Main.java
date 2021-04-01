package bj2798;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int near = 0;	// 카드 3장의 합중 M에 가까운 수
        int sub = 300000;	// M과 카드 3장의 합의 차

        String nm = br.readLine();	// 첫째줄 입력
        String cardNums = br.readLine();	// 둘째줄 입력

        String nStr = nm.split(" ")[0];
        int n = Integer.parseInt(nStr);	// 카드의 개수

        String mStr = nm.split(" ")[1];
        int m = Integer.parseInt(mStr);	// 딜러가 정한 숫자 M

        int[] cards = new int[n];
        for(int i=0; i<n; i++)
        {
            String numStr = cardNums.split(" ")[i];
            cards[i] = Integer.parseInt(numStr);
        }

        for(int i=0; i<n-2; i++)
        {
            for(int j=i+1; j<n-1; j++)
            {
                for(int k=j+1; k<n; k++)
                {
                    int sum = cards[i]+cards[j]+cards[k];
                    // 문제를 제대로 읽자. 3개의 합이 M을 넘지 않아야한다.
                    int subNow = m - sum;
                    if(subNow < 0)
                        continue;

                    if(subNow < sub)
                    {
                        sub = subNow;
                        near = sum;
                    }
                }
            }
        }
        bw.write(Integer.toString(near));
        bw.flush();
        bw.close();
    }
}