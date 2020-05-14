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

public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Scanner scanner = new Scanner(System.in);
        
         EJEMPLO DEL EXCEL.*/
        String text = "add\n" + "A\n" + "6\n"
                + "add\n" + "B\n" + "2\n"
                + "p\n"
                + "add\n" + "C\n" + "4\n"
                + "add\n" + "D\n" + "2\n"
                + "p\n"
                + "p\n"
                + "add\n" + "E\n" + "5\n"
                + "p\n"
                + "add\n" + "F\n" + "3\n"
                + "c\n"
                + "q\n";

        Scanner scanner = new Scanner(text);

        Time time = new Time(0);
        RoundRobin roundRobin = new RoundRobin();
        Cpu cpu = new Cpu(time, roundRobin);

        while (true) {
            System.out.println("q - to quit and show the metrics for finished processes\n"
                    + "p - to pass\n"
                    + "add - to add process\n"
                    + "c - to clear queue\n");
            System.out.print("Option: ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            } else if (input.equals("p")) {
                cpu.work();
                time.advanceTime();
                continue;
            } else if (input.equals("add")) {
                System.out.print("Process name: ");
                String name = scanner.nextLine();
                int duration = readInt(scanner);
                cpu.add(new Process(duration, time.getTime(), name));
                cpu.work();
                time.advanceTime();
            } else if (input.equals("c")) {
                cpu.clearQueue();
            } else {
                System.out.println("Invalid command, please try again.\n");
            }
        }
        System.out.println("\n\n");
        cpu.metrics();
    }

    public static int readInt(Scanner scanner) {
        while (true) {
            System.out.print("Duration of the process: ");
            try {
                int duration = Integer.parseInt(scanner.nextLine());
                if(duration<1){
                    System.out.println("Invalid duration");
                    continue;
                }
                return duration;
            } catch (Exception e) {
                System.out.println("User input was not a number.");
            }
        }
    }
}
