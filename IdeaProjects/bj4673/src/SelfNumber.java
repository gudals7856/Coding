package bj4673;

public class SelfNumber {

    public static int d(int num) {
        int r;
        int sum = num;

        // 1의 자리수에서도 더하기가 이루어져야 하므로 do-while문
        do
        {
            r = num % 10;
            sum += r;
            num /= 10;
        }while(num != 0);

        return sum;
    }
asdfasdf
    public static void main(String[] args) {
        boolean[] a = new boolean[10001];
        int isConstructor;

        a[0] = false; // 숫자 0은 다루지 않으므로 제외

        // 0을 제외한 모든 인덱스에 true로 만들어놓는다.
        // 셀프넘버가 맞을경우 true, 아니면 false
        for(int i=1; i<10001; i++)
        {
            a[i] = true;
        }

        // 1부터 10000까지 d()함수를 진행한다
        for(int i=1; i<10001; i++)
        {
            isConstructor = d(i);
            if(isConstructor <= 10000)
                a[isConstructor] = false;
        }

        // 1~10000까지의 수 중 셀프넘버인 수를 출력
        for(int i=1; i<10001; i++)
        {
            if(a[i] == true)
            {
                System.out.println(i);
            }
        }
    }
}
