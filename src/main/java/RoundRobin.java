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
import java.util.Collections;

import java.util.Queue;
import java.util.LinkedList;

public class RoundRobin {
    private int quatum;
    private Process activeProcess;
    private ArrayList<Process> queue;
    private Queue<Process> cola;
    private ArrayList<Process> registry;
    
    public RoundRobin(int maxTime, ArrayList<Process> registry){
        this.quatum = maxTime;
        this.activeProcess = new Process();
        this.queue = new ArrayList<>();
        this.registry = registry;
        this.cola = new LinkedList<>();
    }
    
    public RoundRobin(ArrayList registry) {
        this(2, registry);
    }
    
    public Process getActiveProcess(){
        
        if(cola.peek().getDuration() == 0){ //si el proceso finalizo
            cola.remove();
            
        if(cola.size() == 1)
            return cola.peek();
            
        }else if (this.registry.size() >= this.quatum) { //chequea si el proceso se ejecuto q veces
            int lastIndex = registry.size() - 1;
            boolean notEqualFound = false;
            for (int i = 0; i < this.quatum; i++) {
                if (cola.peek().equals(registry.get(lastIndex - i))) {
                    continue;
                }
                notEqualFound = true;
                break;
            }
            if (notEqualFound == false) {
                cola.add(cola.remove());
            }
        }
        
        return cola.peek();
    }
    
    public void add(Process process){
        cola.add(process);
    }
    
    
    public void setQuatum(int q){
        this.quatum = q;
    }
    
    public Queue getQueue(){
        return this.cola;
    }
    

    /*
    public void add(Process process){
        queue.add(process);
    }
    
    
    
    public Process setActive(){
        Process candidate = this.queue.get(0);//canidato a ser proceso activo

        if (this.registry.getSizeOfFinishedProcess() >= this.quatum && 
                candidate.equals(this.registry.getLastProcess()) && //si ya se ejecuto dos veces
                candidate.equals(this.registry.getBeforeLastProcess())){
            Collections.rotate(this.queue, -1); //se pone el proceso al final de la cola
            
        }else if(candidate.getDuration() == 0){
            this.queue.remove(0); //si termino se elimina de la cola
        }
        return this.queue.get(0); // retorna el proceso activo
    }


    
    public void setPriority(){
        if(this.activeProcess.equals(registry.getLastProcess()) && this.activeProcess.equals(registry.getBeforeLastProcess())){
           Collections.rotate(this.queue, -1);
        }
        //si el proceso que esta activo ya estuvo activo en los dos tiempos anteriores, entonces muevelo al ultimo en la cola
    }
*/
    
}
