package com.knoldus.Question1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Runnable {
    private int number;

    public Task(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Number is: " + number);
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        // Executor Service for creating 10 instances of Task
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //using Future interface to store future object
        Future<?>[] future = new Future[10];

        for (int indexOfThread = 0; indexOfThread < 10; indexOfThread++) {
            Task task = new Task(indexOfThread);
            future[indexOfThread] = executor.submit(task);
            try
            {
                future[indexOfThread].get();

            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
        executor.shutdown();
    }
}

