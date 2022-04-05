import java.util.concurrent.Semaphore;

public class Philosophers {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        FirstPhilosopher firstPhilosopher = new FirstPhilosopher(semaphore);
        SecondPhilosopher secondPhilosopher = new SecondPhilosopher(semaphore);
        ThirdPhilosopher thirdPhilosopher = new ThirdPhilosopher(semaphore);
        FourthPhilosopher fourthPhilosopher = new FourthPhilosopher(semaphore);
        FifthPhilosopher fifthPhilosopher = new FifthPhilosopher(semaphore);


        Thread thread1 = new Thread(firstPhilosopher);
        Thread thread2 = new Thread(secondPhilosopher);
        Thread thread3 = new Thread(thirdPhilosopher);
        Thread thread4 = new Thread(fourthPhilosopher);
        Thread thread5 = new Thread(fifthPhilosopher);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}


class Table {
    static boolean fork1 = true;
    static boolean fork2 = true;
    static boolean fork3 = true;
    static boolean fork4 = true;
    static boolean fork5 = true;

}

class FirstPhilosopher implements Runnable {
    private Semaphore semaphore;

    public FirstPhilosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("FirstPhilosopher is waiting....");
            if (Table.fork1 == true && Table.fork2 == true) {
                System.out.println("FirstPhilosopher take a fork's");
                Table.fork1 = false;
                Table.fork2 = false;
                System.out.println("FirstPhilosopher are eating...");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Table.fork1 = true;
            Table.fork2 = true;
            System.out.println("FirstPhilosopher ends eat and put fork1 and fork2");
            System.out.println("FirstPhilosopher began to meditate");
            System.out.println("******************************************************");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }

    }
}

class SecondPhilosopher implements Runnable {
    private Semaphore semaphore;

    public SecondPhilosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("SecondPhilosopher is waiting....");
            if (Table.fork2 == true && Table.fork3 == true) {
                System.out.println("SecondPhilosopher take a fork's");
                Table.fork2 = false;
                Table.fork3 = false;
                System.out.println("SecondPhilosopher are eating...");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Table.fork2 = true;
            Table.fork3 = true;
            System.out.println("SecondPhilosopher ends eat and put fork2 and fork3");
            System.out.println("SecondPhilosopher began to meditate");
            System.out.println("******************************************************");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }

    }

}

class ThirdPhilosopher implements Runnable {
    private Semaphore semaphore;

    public ThirdPhilosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("ThirdPhilosopher is waiting....");
            if (Table.fork3 == true && Table.fork4 == true) {
                System.out.println("ThirdPhilosopher take a fork's");
                Table.fork3 = false;
                Table.fork4 = false;
                System.out.println("ThirdPhilosopher are eating...");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Table.fork3 = true;
            Table.fork4 = true;
            System.out.println("ThirdPhilosopher ends eat and put fork3 and fork4");
            System.out.println("ThirdPhilosopher began to meditate");
            System.out.println("******************************************************");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }

    }

}

class FourthPhilosopher implements Runnable {
    private Semaphore semaphore;

    public FourthPhilosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("FourthPhilosopher is waiting....");
            if (Table.fork4 == true && Table.fork5 == true) {
                System.out.println("FourthPhilosopher take a fork's");
                Table.fork4 = false;
                Table.fork5 = false;
                System.out.println("FourthPhilosopher are eating...");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Table.fork4 = true;
            Table.fork5 = true;
            System.out.println("FourthPhilosopher ends eat and put fork4 and fork5");
            System.out.println("FourthPhilosopher began to meditate");
            System.out.println("******************************************************");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }

    }
}

class FifthPhilosopher implements Runnable {
    private Semaphore semaphore;

    public FifthPhilosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("FifthPhilosopher is waiting....");
            if (Table.fork5 == true && Table.fork1 == true) {
                System.out.println("FifthPhilosopher take a fork's");
                Table.fork5 = false;
                Table.fork1 = false;
                System.out.println("FifthPhilosopher are eating...");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Table.fork5 =true;
            Table.fork1 = true;
            System.out.println("FifthPhilosopher ends eat and put fork5 and fork1");
            System.out.println("FifthPhilosopher began to meditate");
            System.out.println("******************************************************");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }

    }
}