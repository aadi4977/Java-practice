class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        next = null;
    }
}

class TaskScheduler {

    Task head = null;
    Task current = null;

    // Insert at beginning
    void insertBeginning(int id, String name, int priority, String dueDate) {

        Task newNode = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Task temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at end
    void insertEnd(int id, String name, int priority, String dueDate) {

        Task newNode = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Task temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at position
    void insertPosition(int pos, int id, String name, int priority, String dueDate) {

        if (pos == 1) {
            insertBeginning(id, name, priority, dueDate);
            return;
        }

        Task newNode = new Task(id, name, priority, dueDate);
        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by Task ID
    void deleteTask(int id) {

        if (head == null)
            return;

        Task temp = head;
        Task prev = null;

        do {
            if (temp.id == id)
                break;

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        if (temp.id != id) {
            System.out.println("Task not found");
            return;
        }

        if (temp == head) {

            Task last = head;

            while (last.next != head)
                last = last.next;

            head = head.next;
            last.next = head;

        } else {
            prev.next = temp.next;
        }

        System.out.println("Task deleted");
    }

    // View current task and move to next
    void nextTask() {

        if (head == null)
            return;

        if (current == null)
            current = head;
        else
            current = current.next;

        System.out.println("Current Task:");
        System.out.println(current.id + " " + current.name + " " + current.priority + " " + current.dueDate);
    }

    // Display all tasks
    void display() {

        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;

        do {
            System.out.println(temp.id + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    void searchByPriority(int priority) {

        if (head == null)
            return;

        Task temp = head;

        do {
            if (temp.priority == priority) {
                System.out.println(temp.id + " " + temp.name + " " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedulerSystem {

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        scheduler.insertBeginning(1, "Assignment", 2, "10-Mar");
        scheduler.insertEnd(2, "Project", 1, "15-Mar");
        scheduler.insertEnd(3, "Presentation", 3, "20-Mar");

        System.out.println("All Tasks:");
        scheduler.display();

        System.out.println("\nCurrent Task:");
        scheduler.nextTask();

        System.out.println("\nNext Task:");
        scheduler.nextTask();

        System.out.println("\nSearch by Priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nDelete Task ID 2:");
        scheduler.deleteTask(2);

        System.out.println("\nTasks After Deletion:");
        scheduler.display();
    }
}