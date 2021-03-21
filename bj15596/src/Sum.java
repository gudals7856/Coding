package bj15596;

public class Sum {

    static long sum(int[] a) {
        long ans = 0;
        int size = a.length;
        for(int i=0; i<size; i++)
        {
            ans += a[i];
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 8};
        sum(a);
    }
}
