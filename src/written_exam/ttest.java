package written_exam;

import java.util.HashMap;

public class ttest {
    static String getIndexAndLongest(String users) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < users.length(); i++) {
            if (users.charAt(i) == 'b') {
                int j = i + 1;
                while (j < users.length()) {
                    if (users.charAt(j) == 'g') {
                        map.put(i, map.getOrDefault(i, 0) + 1);
                    } else {
                        break;
                    }
                    j++;
                }
            }
        }

        for (int i = users.length() - 1; i >= 0; i--) {
            if (users.charAt(i) == 'b') {
                int j = i - 1;
                while (j >= 0) {
                    if (users.charAt(j) == 'g') {
                        map.put(i, map.getOrDefault(i, 0) + 1);
                    } else {
                        break;
                    }
                    j--;
                }
            }
        }

        int res = -1;
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "bgbbbgbggbgbg";
        ttest.getIndexAndLongest(s);
    }
}
