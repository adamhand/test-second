package thread.single_pro_con_pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Productor implements Runnable {
    private PipedOutputStream pos;
    private int count = 0;

    Productor(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                pos.write(count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {
    private PipedInputStream pis;

    Consumer(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("<<< " + pis.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SingleProConPipe {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();

        try {
            pos.connect(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Productor p = new Productor(pos);
        Consumer c = new Consumer(pis);

        new Thread(p).start();
        new Thread(c).start();
    }
}
