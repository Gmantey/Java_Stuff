package com.goddy.lab11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Lab11: Concurrency
 * A simple Player class which may cause race conditions in multi-thread program.
 *
 */
public class Player {
    private AtomicInteger a = new AtomicInteger(5);
    public static Object obj = new Object();
    private int x;	//x position of the player

    private int hp;		//health point of the player

    public Player(int x, AtomicInteger a, int hp){
        this.x = x;
        this.a = a;
        this.hp = hp;
    }

    public void printPlayer(){
        System.out.printf("x position:\t%d\ny position:\t%d\nhealth point:\t%d\n", x, a, hp);
    }

     public synchronized void   moveLeft()  {
        x --;
    }
     public synchronized void  moveRight(){
        x ++;
    }

    public void moveUp(){
        a.decrementAndGet();
    }
    public void moveDown(){
        a.incrementAndGet();
    }

    public void loseHealth() {
        synchronized (obj){
            hp --;
        }

    }
    public void gainHealth(){
        synchronized (obj){
            hp ++;
        }
    }

}
