/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.*;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static int Answer;
    static int t;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        String str = "";
        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;

            int n = sc.nextInt();
            t = sc.nextInt();
            String num = sc.next();

            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = 2;
            }

            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                B[i] = num.charAt(i);
                if (B[i] == 0) {
                    if (i - t >= 0) {
                        A[i - t] = 0;
                    }
                    if (i + t < n) {
                        A[i + t] = 0;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (B[i] == 0)
                    continue;
                if (i + t < n) {
                    if (i + (2 * t) < n && B[i + (2 * t)] == 1) {
                        B[i + t] = 1;
                    }
                    else if () {

                    }
                }
            }

            // Print the answer to standard output(screen).
            str = str + "Case #" + (test_case+1) + "\n" + Answer + "\n";
        }
        System.out.println(str);
    }
}