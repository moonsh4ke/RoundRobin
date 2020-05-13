/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class Time {
    private int time;
    
    public Time(int time){
        this.time = time;
    }
    
    public int getTime(){
        return time;
    }
    
    public void advanceTime(){
        time++;
    }
}
