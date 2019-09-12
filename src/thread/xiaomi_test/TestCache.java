package thread.xiaomi_test;

import java.util.LinkedList;
import java.util.List;

public class TestCache {
    private static volatile List<Object> list = new LinkedList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }
}

class Main {
    public static void main(String[] args) {
        Object o = new Object();

        TestCache c1 = new TestCache();

        Thread t1 = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                synchronized (o) {
                    while (i++ < 10) {
                        c1.add(new Object());
                        System.out.println(c1.size());
                        if (c1.size() == 5) {
                            o.notify();
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        o.wait();
                        System.out.println("five elements");
                        o.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2.start();
        t1.start();
    }
}
