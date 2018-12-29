package com.onestage.chapter3;

public class ThreadService  {

    private Thread executeThread;
    private boolean finish = false;


    public void execute(Runnable task){

        executeThread = new Thread(){
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    finish = true;
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills){
        long currentTime = System.currentTimeMillis();
        while(!finish){
            if((System.currentTimeMillis() - currentTime >= mills)){
                System.out.println("任务超时。。。结束");
                executeThread.interrupt();
                break;
            }
            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }
    }
}
