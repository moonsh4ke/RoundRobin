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
    
    public RoundRobin(int maxTime){
        this.quatum = maxTime;
    }
    
    public RoundRobin() {
        this(2);
    }
    
    public Process getActiveProcess(Queue<Process> queue, ArrayList<Process> registry){
        if(queue.size() <= 1)return queue.peek();
        else if (registry.size() >= this.quatum) {
            int lastIndex = registry.size() - 1;
            boolean notEqualFound = false;
            for (int i = 0; i < this.quatum; i++) {
                if (queue.peek().equals(registry.get(lastIndex - i))) {
                    continue;
                }
                notEqualFound = true;
                break;
            }
            if (notEqualFound == false) {
                queue.add(queue.remove());
            }
        }
        return queue.peek();
    }
        
}
