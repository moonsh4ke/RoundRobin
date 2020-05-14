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
import java.util.Queue;
import java.util.LinkedList;

public class Cpu {

    private RoundRobin roundrobin;
    private Time time;
    private ArrayList<Process> registry;
    private ArrayList<Process> finishedProcesses;
    private Queue<Process> queue;
    private Process activeProcess;

    public Cpu(Time time, RoundRobin roundrobin) {
        this.time = time;
        this.roundrobin = roundrobin;
        this.registry = new ArrayList<>();
        this.finishedProcesses = new ArrayList<>();
        this.queue = new LinkedList<>();
        this.activeProcess = null;
    }

    public void add(Process process) {
        this.queue.add(process);
    }

    public void work() {
        this.activeProcess = this.roundrobin.getActiveProcess(this.queue, this.registry);
        if (this.activeProcess != null) {
            this.activeProcess.tDoneIncrease();
            this.registry.add(this.activeProcess);
            this.status();
            this.update();
        }
    }

    public void status() {
        System.out.println("\n----------------Status at time " + this.time.getTime() + "-----------------\n"
                + "Active process: " + this.activeProcess + "\n"
                + "Queue: " + this.queue + "\n"
                + "**************************************************\n");
    }

    public void update() {
        if (this.activeProcess.isFinished()) {
            Process finishedProcess = queue.poll();
            this.finishedProcesses.add(finishedProcess);
            System.out.println("Process: " + finishedProcess.getName() + " finished.");
            this.activeProcess.setTfinished(time.getTime());
        }
        this.activeProcess = null;
    }

    public void metrics() {
        double waitAvg, returnAvg, normalizedReturnAvg;
        waitAvg = returnAvg = normalizedReturnAvg = 0.0;
        for (Process p : this.finishedProcesses) {
            System.out.println("Process name: " + p.getName() + ", Finalization: " + p.getTfinished() + ", Waited: " + p.waitTime() + ", Return: " + p.returnTime() + ", Normalized return: " + p.normalizedReturn());
            waitAvg += p.waitTime();
            returnAvg += p.returnTime();
            normalizedReturnAvg += p.normalizedReturn();
        }
        int size = this.finishedProcesses.size();
        System.out.println("Averages: \n"
                + "wait time: " + waitAvg / size + "\n"
                + "return: " + returnAvg / size + "\n"
                + "Normalized return: " + normalizedReturnAvg / size + "\n");
    }

    public void clearQueue() {
        while (queue.peek() != null) {
            this.work();
            this.time.advanceTime();
        }
    }
}
