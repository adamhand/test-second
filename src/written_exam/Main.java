package written_exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Character> queue1 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)  {
            if (chars[i] == ' ') {
                continue;
            } else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                 if (chars[i + 1] != ' ') {
                     i++;
                     int temp = 0;
                     while (chars[i] != ' ') {
                         temp = temp * 10 +  Integer.parseInt(String.valueOf(chars[i]));
                         i++;
                     }
                     temp = -temp;
                     queue.add(temp);
                 }else {
                     queue1.add(chars[i]);
                 }
            } else {
                queue.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }

//        while (!queue.isEmpty())
//            System.out.println(queue.poll());
//        while (!queue1.isEmpty())
//            System.out.println(queue1.poll());

        List<Integer> list = new ArrayList<>();
        Queue<Character> queue2 = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (!queue1.isEmpty()) {
            list.add(queue.poll());
            switch (queue1.peek()) {
                case '+' :
                    while (queue1.peek() == '+' || queue1.peek() == '-') {
                        list.add(queue.poll());
                        queue2.add(queue1.poll());
                    }
                    break;
                case '-' :
                    while (queue1.peek() == '+' || queue1.peek() == '-') {
                        list.add(queue.poll());
                        queue2.add(queue1.poll());
                    }
                    break;
                case '*' :
                    while (queue1.peek() == '*' || queue1.peek() == '/') {
                        list.add(queue.poll());
                        queue2.add(queue1.poll());
                    }
                    break;
                case '/' :
                    while (queue1.peek() == '*' || queue1.peek() == '/') {
                        list.add(queue.poll());
                        queue2.add(queue1.poll());
                    }
                    break;
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i) + ' ' + queue2.poll());
            }
            list.clear();
        }
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }
        System.out.println(sb.toString());
        //System.out.println("1 + 2 + 3 + -5 * -4 + 1"); // 3 + 2 + 1 + -4 * -5 + 1
    }
}
