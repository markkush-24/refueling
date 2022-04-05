import java.util.concurrent.Semaphore;

public class SharedTask {
    public static void main(String[] args) {
        Semaphore resources = new Semaphore(1);
        Reader reader = new Reader(resources);
        Writer writer = new Writer(resources);


        Thread thread = new Thread(writer);
        Thread thread1 = new Thread(writer);
        Thread thread2 = new Thread(writer);
        Thread thread3 = new Thread(writer);
        Thread thread4 = new Thread(writer);

        Thread thread5 = new Thread(reader);
        Thread thread6 = new Thread(reader);
        Thread thread7 = new Thread(reader);


        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        thread5.start();
        thread6.start();
        thread7.start();
    }


}

class Shared {
    static int value;
    static boolean changed;

}

class Reader implements Runnable {
    private Semaphore resources;

    public Reader(Semaphore resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        try {
            resources.acquire();
//            for (int i = 0; i < 5; i++) {
                System.out.println("Reader is waiting...");
                Shared.changed = true;
                if (Shared.changed == true) {
                    System.out.println("Reader is reading...");
                    Thread.sleep(2000);
//                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resources.release();
        }
    }
}

class Writer implements Runnable {
    private Semaphore resources;

    public Writer(Semaphore resources) {
        this.resources = resources;
    }


    public void run() {
        try {
            resources.acquire();
//            for (int i = 0; i < 3; i++) {
                System.out.println("Writer is waiting...");
                Shared.changed = false;
                if (Shared.changed == false) {
                    Shared.value += 1;
                    System.out.println("Writer is changing value...");
                    System.out.println("Shared.value : " + Shared.value);
                    Thread.sleep(2000);
                }
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resources.release();
        }
    }
}
