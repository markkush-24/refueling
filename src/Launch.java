
public class Launch {
    public static void main(String[] args) {

        GasStation gasStation = new GasStation();
        ProducerGas producerGas = new ProducerGas(gasStation);
        Client car = new Client(gasStation);
        Client car1 = new Client(gasStation);
        Client car2 = new Client(gasStation);
        Client car3 = new Client(gasStation);
        Client car4 = new Client(gasStation);
        Client car5 = new Client(gasStation);
        Client car6 = new Client(gasStation);

        Thread thread = new Thread(producerGas);


        Thread thread1 = new Thread(car1);
        Thread thread2 = new Thread(car2);
        Thread thread3 = new Thread(car3);
        Thread thread4 = new Thread(car4);
        Thread thread5 = new Thread(car5);
        Thread thread6 = new Thread(car6);
        Thread thread7 = new Thread(car);

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


class GasStation {


    private double gasCounter = 0;

    public synchronized void getGas(Car car) throws InterruptedException {
        while (gasCounter <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(5);
        gasCounter -= 0.05;
        car.remainder += 0.05;
        System.out.println("Car is refueling...");
        System.out.println("gasCounter is " + gasCounter);
        System.out.println("The current amount of gasoline in the tank " + car.value + " , remainder is " + car.remainder);
        notify();
    }

    public synchronized void putGasInStation() {
        while (gasCounter >= 1000) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gasCounter += 10;
        System.out.println("Replenishment of gasoline stocks");
        notify();
    }


}

class ProducerGas implements Runnable {
    GasStation gasStation;

    ProducerGas(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gasStation.putGasInStation();
        }
    }
}


class Client implements Runnable {
    GasStation gasStation;

    Client(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        double min = 50;
        double max = 80;
        double d = Math.random()*(max-min+1)+min;
        double min1 = 0;
        double max1 = 100;
        double d1 = Math.random()*(max1-min1+1)+min1;
        Car car = new Car(d,d1);
        System.out.println("countFuel " + d);
        System.out.println("countRemainder " + d1);

        for (int i = 0; i < 1000; i++) {
            try {

                while (car.remainder <= 100){
                    gasStation.getGas(car);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Car {
    double value;
    double remainder;

    public Car(double value, double remainder) {
        this.value = value;
        this.remainder = remainder;
    }

    public Car() {
    }
}