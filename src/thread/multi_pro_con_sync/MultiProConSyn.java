package thread.multi_pro_con_sync;

import static java.lang.Thread.sleep;

class Resource {
    private String name;
    private int count = 0;
    private boolean flag = false;

    public synchronized void produce(String name) {
        while (flag) {
            try {
                this.wait();
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(">>> " + Thread.currentThread().getName() + " 生产 " + this.name);
        flag = true;
        notifyAll();
    }

    public synchronized void consume() {
        while (!flag) {
            try {
                this.wait();
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("<<<<<< " + Thread.currentThread().getName() + " 消费 " + name);
        flag = false;
        notifyAll();
    }
}

class Producer implements Runnable{
    private Resource r;

    Producer (Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.produce("烧鸡");
        }
    }
}

class Consumer implements Runnable {
    private Resource r;

    Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.consume();
        }
    }
}

public class MultiProConSyn {
    public static void main(String[] args) {
        Resource r = new Resource();

        Producer p = new Producer(r);
        Consumer c = new Consumer(r);

        Thread p0 = new Thread(p);
        Thread p1 = new Thread(p);
        Thread c0 = new Thread(c);
        Thread c1 = new Thread(c);

        p0.start();
        p1.start();
        c0.start();
        c1.start();
    }
}
