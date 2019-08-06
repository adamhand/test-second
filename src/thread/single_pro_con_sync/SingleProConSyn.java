package thread.single_pro_con_sync;

class Resource {
    private String name;
    private int count;
    private boolean flag = false;

     public synchronized void produce(String name) {
         if (flag) {
             try {
                 this.wait();
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         this.name = name + count;
         count++;
         System.out.println(">>> " + Thread.currentThread().getName() + " produce " + this.name);
         flag = true;
         notify();
     }

     public synchronized void consume(){
         if (!flag) {
             try {
                 this.wait();
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         System.out.println("<<< " + Thread.currentThread().getName() + " consume " + this.name);
         flag = false;
         notify();
     }
}

class Producer implements Runnable{
    private Resource r;

    Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.produce("德州扒鸡");
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


public class SingleProConSyn {
    public static void main(String[] args) {
        Resource r = new Resource();

        Thread p = new Thread(new Producer(r));
        Thread c = new Thread(new Consumer(r));

        p.start();
        c.start();
    }
}


