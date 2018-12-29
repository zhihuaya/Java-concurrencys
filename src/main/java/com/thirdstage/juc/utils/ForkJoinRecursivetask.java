package com.thirdstage.juc.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinRecursivetask {

    private final static int MAX_THRESHOLD = 200;

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new CalculatedRecursiveTast(0, 1000));
        try {
            Integer result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static class CalculatedRecursiveTast extends RecursiveTask<Integer> {

        private final int start;
        private final int end;

        public CalculatedRecursiveTast(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= MAX_THRESHOLD){
                return IntStream.rangeClosed(start,end).sum();
            }else {
                int middle =(start+end)/2;
                CalculatedRecursiveTast leftTask = new CalculatedRecursiveTast(start,middle);
                CalculatedRecursiveTast rightTask = new CalculatedRecursiveTast(middle+1,end);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join()+rightTask.join();
            }
        }
    }

}
