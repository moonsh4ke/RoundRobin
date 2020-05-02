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

public class Cpu {
    private RoundRobin planner;
    private Metrics table;
    private ArrayList<Process> registry;
    private Process activeProcess;
    
    public Cpu(ArrayList<Process> registry){
        this.registry = registry;
        this.planner = new RoundRobin(registry);
        this.table = new Metrics();
        this.activeProcess = new Process();
    }
    
    
    public void add(Process process){
        this.planner.add(process);
    }
    
    public void work(){
        this.activeProcess = this.planner.getActiveProcess();
        this.status();
        if(this.activeProcess != null){
            this.activeProcess.reduceDuration();
            this.registry.add(this.activeProcess);
        }
    }
    
    public void callPlanner(){
        //this.activeProcess = planner.setActive();
    }
    
    public void status(){
        System.out.println("Array list (registry): " + this.registry);
        
        System.out.println("Active process: " + this.activeProcess);
        
        
        System.out.println("RR cola: " + this.planner.getQueue());
    }
    
    
}
