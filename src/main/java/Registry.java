/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
import java.util.ArrayList;

public class Registry {
    private ArrayList<Process> finishedProcess;
   
    
    public Registry(){
        this.finishedProcess = new ArrayList<>();
    }
    
    public ArrayList<Process> getFinishedProcess(){
        return this.finishedProcess;
    }
    
    public int getSizeOfFinishedProcess(){
        return this.finishedProcess.size();
    }
    
    public void add(Process process){
        finishedProcess.add(process);
    }
    
    public Process getLastProcess(){
        return this.finishedProcess.get(finishedProcess.size()-1);
    }
    
    public Process getBeforeLastProcess(){
        return this.finishedProcess.get(this.finishedProcess.size()-2);
    }
}
