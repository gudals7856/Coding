/*
백준 17298번
오큰수 (스택)
 */

import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] num;
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(str.nextToken());

        // 시작할 때 수열의 가장 앞 수의 인덱스를 스택의 넣고 시작한다.
        st.push(0);
        
        // 수들을 모두 확인하면 진행
        for (int i = 1; i < n; i++) {

            // 스택이 비어있지 않다면 현재 num과 스택 내의 수들을 비교한다.
            // 스택 안의 수들과 비교하다가 현재 num이 더 작으면 break, 크면 해당 인덱스 수를 현재 num으로 바꿈
            while (!st.isEmpty()) {
                if (num[i] <= num[st.peek()])
                    break;
                else
                    num[st.pop()] = num[i];
            }
            st.push(i);
        }

        // 스택에 남아있는 인덱스에 해당하는 수들을 -1로 저장
        while (!st.isEmpty())
            num[st.pop()] = -1;
        
        for (int i = 0; i < n; i++) {
            bw.write(num[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
