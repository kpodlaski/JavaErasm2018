package lesson4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Krzysztof Podlaski on 10.05.2018.
 */
public class JobToDo implements Runnable {
    Counter counter3;
    int id;
    int counter=0;
    static int counter2 = 0;
    static Object sObserver= "Observer";
    static CyclicBarrier barrier;

    public JobToDo(int i,Counter c) {
        this.id=i;
        this.counter3 =c;
    }

    @Override
    public void run() {
        System.out.println("Start Task "+id);
        for(int i=0; i<10; i++){
            counter+=i;
            synchronized (sObserver){
                counter2+=i;
            }
            counter3.add(i);
            System.out.println(id+" : "+counter);
        }
            System.out.println("End Task " + id );
        try {
            barrier.await(); //the thread commes to barrier
            Thread.sleep(30);
            System.out.println("Real End of Task " + id );
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        int N =100;
        Counter counter = new Counter();
        barrier = new CyclicBarrier(
                N,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Expected counter 2 "+ (45*N));
                        System.out.println("Obtained counter 2 "+ counter2);
                        System.out.println("Obtained counter 3 "+ counter.get());
                        System.out.println("End Of the Program");
                    }
                }
        );
        Thread[] threads = new Thread[N];
        for (int i=0; i<N; i++){
            threads[i]=new Thread(new JobToDo(i,counter) );
        }
        System.out.println("Starting Threads:");
        for (int i=0; i<N; i++){
            threads[i].start();
        }

        while (counter2<45*N){
            Thread.sleep(30);
        }


    }
}

class Counter{
    private int value=0;

    public void add(int i){
        synchronized (this){
            value+=i;
        }
    }

    public int get(){
        synchronized(this) {
            return value;
        }
    }
}