package bj1065;

import java.util.Scanner;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static boolean function(int num) {
        // 1 ~ 99까지는 모두 한수이다
        if(num<100)
            return true;
            // 100 ~ 999
        else {
            int a,b,c;
            c = num % 10;	// 1의 자리수
            num /= 10;
            b = num % 10;	// 10의 자리수
            num /= 10;
            a = num;		// 100의 자리수

            int s1 = a - b;
            int s2 = b - c;
            if(s1 == s2)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        for(int i=1; i<num+1; i++)
        {
            boolean check = function(i);
            if(check == true)
                count++;
            else
                continue;
        }
        sb.append(count);
        System.out.println(sb);
        sc.close();
    }
}
