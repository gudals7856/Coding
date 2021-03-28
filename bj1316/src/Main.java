package bj1316;

import java.io.*;
import java.util.Vector;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i=0; i<n; i++)
            str[i] = br.readLine();

        for(int i=0; i<n; i++)
        {
            boolean check = isgroupword(str[i]);
            if(check == true)
                sum++;
            else
                continue;
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }

    public static boolean isgroupword(String str) {
        Vector<Character> c = new Vector<Character>();

        for(int i=0; i<str.length(); i++)
        {
            // 단어의 첫 알파벳
            if(i==0)
                continue;

                // 단어의 첫 알파벳을 제외한 알파벳
            else
            {
                // 마지막 알파벳이 연속일 경우(abaaa 등) c안에 알파벳이 들어가있지 않으므로 이전 알파벳과 c벡터를 한번 더 확인한다.
                if(str.charAt(i) == str.charAt(i-1))
                    if(i==str.length()-1) {
                        for(int j=0; j<c.size(); j++)
                        {
                            if(str.charAt(i) == c.get(j))
                                return false;
                            else
                                continue;
                        }
                    }
                    else
                        continue;
                else
                {
                    // c벡터안에 추가할 알파벳이 이미 들어가 있는지 확인. 들어가있다면 false
                    for(int j=0; j<c.size(); j++)
                    {
                        if(str.charAt(i-1) == c.get(j))
                            return false;
                        else
                            continue;
                    }
                    c.add(str.charAt(i-1));

                    // 단어의 마지막 알파벳일 경우 c벡터를 한번더 확인한다
                    if(i==str.length()-1) {
                        for(int j=0; j<c.size(); j++)
                        {
                            if(str.charAt(i) == c.get(j))
                                return false;
                            else
                                continue;
                        }
                    }
                }
            }
        }
        return true;
    }
}
