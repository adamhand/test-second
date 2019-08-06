package thread.multi_pro_con_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

class Resource {
    private boolean flag = false;
    private String name;
    private int count = 0;

    Lock lock = new ReentrantLock();
    Condition proCondition = lock.newCondition();
    Condition conCondition = lock.newCondition();

    public void produce(String name) {
        try {
            lock.lock();
            while (flag) {
                proCondition.await();
                sleep(200);
            }
            this.name = name + count;
            count++;
            System.out.println(">>> " + Thread.currentThread().getName() + " produce " + this.name);
            flag = true;
            conCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lock();
            while (!flag) {
                conCondition.await();
                sleep(200);
            }
            System.out.println("<<<<<< " + Thread.currentThread().getName() + " consume " + this.name);
            flag = false;
            proCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private Resource r;
    Producer (Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.produce("商品");
        }
    }
}

class Consumer implements Runnable {
    private Resource r;
    Consumer (Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.consume();
        }
    }
}

public class MultiProConLock {
    public static void main(String[] args) {
        Resource r = new Resource();

        Producer p = new Producer(r);
        Consumer c = new Consumer(r);

        new Thread(p).start();
        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();
    }
}
