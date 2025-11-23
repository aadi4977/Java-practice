package JAVACOLLECTION;

import java.util.*;

public class FeedbackSystem {

    List<String> allFeedback = new ArrayList<>();   // all messages
    Set<String> uniqueFeedback = new HashSet<>();   // to remove duplicates
    Queue<String> processQueue = new LinkedList<>();// to process in order
    Stack<String> recentStack = new Stack<>();      // most recent feedbacks

    // 1. Add feedback messages
    void addFeedback(String msg) {
        allFeedback.add(msg);
        recentStack.push(msg);  // track recent ones
        System.out.println("Added: " + msg);
    }

    // 2. Remove duplicates and prepare queue
    void prepareProcessing() {
        uniqueFeedback.clear();
        processQueue.clear();

        for (String msg : allFeedback) {
            if (uniqueFeedback.add(msg)) {   // only first time
                processQueue.add(msg);
            }
        }
    }

    void processAll() {
        System.out.println("\nProcessing feedback:");
        while (!processQueue.isEmpty()) {
            String msg = processQueue.poll();
            System.out.println("Processed: " + msg);
        }
    }

    // 3. Display last few feedbacks using stack
    void showRecent(int count) {
        System.out.println("\nLast " + count + " feedbacks:");
        int shown = 0;
        ListIterator<String> it = recentStack.listIterator(recentStack.size());
        while (it.hasPrevious() && shown < count) {
            System.out.println(it.previous());
            shown++;
        }
    }

    // ---- Demo ----
    public static void main(String[] args) {
        FeedbackSystem fs = new FeedbackSystem();

        fs.addFeedback("App is very slow");
        fs.addFeedback("Nice UI");
        fs.addFeedback("App is very slow");  // duplicate
        fs.addFeedback("Add dark mode");

        fs.prepareProcessing();
        fs.processAll();
        fs.showRecent(3);
    }
}

