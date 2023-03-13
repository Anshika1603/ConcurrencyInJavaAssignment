package com.knoldus.Question2;

public class Counter {
    //Volatile keyword to ensure that updated value is printed.
    private static volatile int counter = 0;
    public static void main(String[] args) {

        //Main Thread for Incrementing Counter value
        Thread mainThread = new Thread(() -> {
            while (counter<=10) {
                counter++;
                System.out.println("Counter value incremented");
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException exception)
                {
                    System.out.println(exception.getMessage());
                }
            }
        });

        // Print Thread for Printing Counter Value
        Thread printThread = new Thread(() -> {
            while (counter<=10) {
                System.out.println("The current value of Counter is: " + counter);
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        mainThread.start();
        printThread.start();
    }
}
