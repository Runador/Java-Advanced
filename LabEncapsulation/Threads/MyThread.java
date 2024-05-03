package LabEncapsulation.Threads;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Поток: " + getName());
    }

}
