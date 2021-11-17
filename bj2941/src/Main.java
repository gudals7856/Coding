import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;

public class Main {

    public static void bbeolzit(String str) {
        Map<String, Integer> map = new Hashtable<>();
        map.put("c=", 1);
        map.put("c-", 1);
        map.put("dz=", 1);
        map.put("d-", 1);
        map.put("lj", 1);
        map.put("nj", 1);
        map.put("s=", 1);
        map.put("z=", 1);

        int idx = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < str.length()) {
            boolean flag = false;
            for (int i = idx; i < idx + 3; i++) {
                sb.append(str.charAt(i));
                if (map.containsKey(sb.toString())) {
                    flag = true;
                    break;
                }
                if (i + 1 >= str.length()) break;
            }
            if (flag) {
                idx += sb.length();
                count++;
            } else {
                idx++;
                count++;
            }
            sb.setLength(0);
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (String s : arr) {
            str = str.replace(s, "a");
        }

        System.out.println(str.length());
        // bbeolzit(str);
    }
}
