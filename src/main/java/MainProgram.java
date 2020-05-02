/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
import java.util.Scanner;
import java.util.ArrayList;

public class MainProgram {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
       
        Cpu cpu = new Cpu(new ArrayList<>());
                
        int i = 0;
        while(true){
            String input = scanner.nextLine();
            if(input.equals("q"))
                break;
                
            else if(input.equals("p")){
                cpu.callPlanner();
                cpu.work();
                i++;
                continue;
            }
            int duration = Integer.valueOf(input);
            cpu.add(new Process(duration, i));
            cpu.work();
            i++;
        }
        
    }
    
}
