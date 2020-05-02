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
    private int duration;
    private int arrivalTime;
    
    public Process(int duration, int arrivalTime){
        this.duration = duration;
        this.arrivalTime = arrivalTime;
    }
    
    public Process() {
        this(0, 0);
    }
    
    public int getDuration(){
        return this.duration;
    }
    
    public void reduceDuration(){
        this.duration--;
    }
    
    public String toString(){
        return "((Arrival time = " + this.arrivalTime + " , Duration = " + this.duration+"))";
    }
    /*
    public boolean equals(Object compared){
        if (this == compared)
            return true;
        return false;
        
        
        
        Process comparedProcess = (Process) compared;
        
        if(this.arrivalTime == comparedProcess.arrivalTime &&
                this.duration == comparedProcess.duration)
            return true;
        
        return false;
        
    }
    */
}