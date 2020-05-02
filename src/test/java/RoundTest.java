/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;

public class RoundTest {
    
    @Test
    public void activeProcessTest(){
        Process p = new Process(4, 1);
        Process p2 = new Process(5, 1);
        ArrayList registry = new ArrayList<>();
        registry.add(p);
        registry.add(p);
        RoundRobin rr = new RoundRobin(registry);
        rr.add(p);
        //rr.add(p2);
        assertEquals(p, rr.getActiveProcess());
    }
    
    @Test
    public void testingCpuClass(){
        ArrayList registry = new ArrayList<>();
        Process p = new Process(4, 1);
        Cpu cpu = new Cpu(registry);
        
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(true){
            String input = scanner.nextLine();
            if(input.equals("q"))
                break;
            else if(input.equals("p")){
                cpu.callPlanner();
                cpu.work();
                continue;
            }
            int duration = Integer.valueOf(input);
            cpu.add(new Process(duration, i));
            cpu.callPlanner();
            cpu.work();
        }
        
    }
    
}
