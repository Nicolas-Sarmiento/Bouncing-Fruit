package co.edu.uptc.model;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Play implements  Runnable{

    private  int incrementX;
    private  int incrementY;
    private JLabel label;
    private volatile boolean suspend;
    private volatile  boolean finish;

    private final Object lock = new Object();
    private static final int borderLimit = 10;
    public Play(JLabel label) {
        this.label = label;
        this.suspend = false;
        this.finish = false;
        Random rand = new Random();
        this.incrementX = rand.nextInt(5) + 1;
        this.incrementY = rand.nextInt(5) + 1;
    }

    public void pauseThread(){
       this.suspend = true;
    }

    public void resumeThread(){
        if( !suspend ) return;
        synchronized ( lock){
            suspend = false;
            lock.notifyAll();
        }
    }

    public void stopThread(){
        this.finish = true;
    }


    @Override
    public void run() {
        while (!finish){

            synchronized ( lock ) {
                if (suspend){
                    try {
                        lock.wait();
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    if( (label.getX() + label.getWidth() + borderLimit > label.getParent().getWidth()  && incrementX > 0)|| (label.getX() - borderLimit < 0 && incrementX < 0)){
                        incrementX = -incrementX;
                    }
                    if( (label.getY() + label.getWidth() + borderLimit > label.getParent().getHeight() && incrementY > 0) || (label.getY() - borderLimit < 0 && incrementY < 0))  {
                        incrementY = -incrementY;
                    }
                    label.setLocation( label.getX() + incrementX , label.getY() + incrementY);

                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

            }
        }

    }
}
