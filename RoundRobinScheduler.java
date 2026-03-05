class Process {
    int id;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnAroundTime = 0;

    Process next;

    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        next = null;
    }
}

class RoundRobin {

    Process head = null;

    // Add process at end
    void addProcess(int id, int burstTime, int priority) {

        Process newProcess = new Process(id, burstTime, priority);

        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            return;
        }

        Process temp = head;

        while (temp.next != head)
            temp = temp.next;

        temp.next = newProcess;
        newProcess.next = head;
    }

    // Display processes
    void display() {

        if (head == null) {
            System.out.println("No processes");
            return;
        }

        Process temp = head;

        do {
            System.out.println("P" + temp.id + " BT:" + temp.remainingTime + " Priority:" + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Remove process
    void removeProcess(int id) {

        if (head == null)
            return;

        Process temp = head;
        Process prev = null;

        do {

            if (temp.id == id)
                break;

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        if (temp.id != id)
            return;

        if (temp == head) {

            Process last = head;

            while (last.next != head)
                last = last.next;

            if (head.next == head) {
                head = null;
                return;
            }

            head = head.next;
            last.next = head;

        } else {
            prev.next = temp.next;
        }
    }

    // Round Robin Scheduling
    void schedule(int quantum) {

        int time = 0;
        int totalWT = 0;
        int totalTAT = 0;
        int count = 0;

        Process temp = head;

        while (head != null) {

            if (temp.remainingTime > quantum) {

                time += quantum;
                temp.remainingTime -= quantum;

            } else {

                time += temp.remainingTime;
                temp.remainingTime = 0;

                temp.turnAroundTime = time;
                temp.waitingTime = temp.turnAroundTime - temp.burstTime;

                totalWT += temp.waitingTime;
                totalTAT += temp.turnAroundTime;
                count++;

                int id = temp.id;
                temp = temp.next;
                removeProcess(id);

                if (head == null)
                    break;

                continue;
            }

            temp = temp.next;

            System.out.println("\nQueue after round:");
            display();
        }

        System.out.println("\nAverage Waiting Time = " + (double) totalWT / count);
        System.out.println("Average Turnaround Time = " + (double) totalTAT / count);
    }
}

public class RoundRobinScheduler {

    public static void main(String[] args) {

        RoundRobin rr = new RoundRobin();

        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 1);

        System.out.println("Initial Process Queue:");
        rr.display();

        int quantum = 3;

        System.out.println("\nRound Robin Scheduling with Time Quantum = " + quantum);

        rr.schedule(quantum);
    }
}