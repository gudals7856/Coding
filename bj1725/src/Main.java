import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Stack<Item> stk = new Stack<>();
    static long answer = 0;
    static long num;
    static class Item{
        long idx, h;
        Item(long idx, long h){
            this.idx = idx;
            this.h = h;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        N = Integer.valueOf(br.readLine());

        for(int i = 0; i < N; i++){
            num = Long.valueOf(br.readLine());

            while(!stk.isEmpty() && stk.peek().h > num) {
                long getH = stk.pop().h;
                long width = i;

                if (!stk.isEmpty()) {
                    width -= stk.peek().idx + 1;
                    System.out.println(width);
                }


                answer = Math.max(answer, getH * width);
            }

            stk.push(new Item(i, num));
        }

        while(!stk.isEmpty()) {
            long getH = stk.pop().h;
            long width = N;

            if(!stk.isEmpty())
                width -= stk.peek().idx + 1;

            answer = Math.max(answer, getH * width);
        }

        System.out.println(answer);
    }
}
