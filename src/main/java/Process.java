/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class Process {
    private String name;
    private int tCpu;
    private int tDone;
    private int tArrival;
    private int tFinished;
    
    public Process(int duration, int arrivalTime, String name){
        this.tCpu = duration;
        this.tArrival = arrivalTime;
        this.name = name;
    }
    
    public void setTfinished(int time){
        this.tFinished = time;
    }
    
    public int getTcpu(){
        return this.tCpu;
    }
    
    public void tDoneIncrease(){
        this.tDone++;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isFinished(){
        return this.tDone == this.tCpu;
    }
    
    public String toString(){
        return "(Process name: " + this.name + ", tCpu: " + this.tCpu + ", Arrival time: " + this.tArrival + ")";
    }
    
    public int getTfinished(){
        return this.tFinished;
    }
    
    public int waitTime(){
        return this.returnTime() - this.tCpu;
    }
    
    public int returnTime(){
        return this.getTfinished()+1 - this.tArrival;
    }
    
    public double normalizedReturn(){
        return (double)this.returnTime()/this.tCpu;
    }
}