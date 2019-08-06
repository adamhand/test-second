package thread.blocking_queue_test;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

class Person {
    private String name;
    private int money;

    Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    private String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    @Override
    public String toString() {
        return getName() + "[" + "存款" + getMoney() + "]";
    }
}

class MoneyComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getMoney() - o1.getMoney();
    }
}

class ProducerRunnable implements Runnable {
    private static final String name = "明刚红李刘吕赵黄王孙朱曾游丽吴昊周郑秦丘";
    private Random random = new Random();
    private PriorityBlockingQueue<Person> queue;

    ProducerRunnable(PriorityBlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Person person = new Person("小" + name.charAt(i), random.nextInt(1000));
            queue.put(person);
            System.out.println(person + "开始排队");
        }
    }
}

class ConsumerRunnable implements Runnable {
    private PriorityBlockingQueue<Person> queue;

    ConsumerRunnable(PriorityBlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Person person = queue.poll();
            if (person == null) {
                break;
            }
            System.out.println(person + "办理业务");
        }
    }
}

public class PriorityBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Person> queue = new PriorityBlockingQueue<>(100, new MoneyComparator());
        Thread thread = new Thread(new ProducerRunnable(queue));
        thread.start();
        thread.join();
        new Thread(new ConsumerRunnable(queue)).start();
    }
}
