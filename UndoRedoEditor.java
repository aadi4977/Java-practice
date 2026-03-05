class State {

    String text;
    State prev, next;

    State(String text) {
        this.text = text;
        prev = next = null;
    }
}

class TextEditor {

    State head = null;
    State tail = null;
    State current = null;

    int size = 0;
    int limit = 10;   // history limit

    // Add new state
    void addState(String text) {

        State newState = new State(text);

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        // remove redo history
        current.next = null;
        tail = current;

        newState.prev = tail;
        tail.next = newState;
        tail = newState;
        current = newState;

        size++;

        // maintain max size
        if (size > limit) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo
    void undo() {

        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed");
        } else {
            System.out.println("No more undo");
        }
    }

    // Redo
    void redo() {

        if (current.next != null) {
            current = current.next;
            System.out.println("Redo performed");
        } else {
            System.out.println("No more redo");
        }
    }

    // Display current text
    void displayCurrent() {

        if (current == null) {
            System.out.println("Editor empty");
            return;
        }

        System.out.println("Current Text: " + current.text);
    }

}

public class UndoRedoEditor {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!!!");

        editor.displayCurrent();

        editor.undo();
        editor.displayCurrent();

        editor.undo();
        editor.displayCurrent();

        editor.redo();
        editor.displayCurrent();

        editor.addState("Hello Java");

        editor.displayCurrent();
    }
}