package Feb10;

import java.util.*;

class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState current;
    private final int maxHistorySize = 10;
    private int historySize = 0;

    public TextEditor() {
        head = new TextState("");  // Initial empty state
        current = head;
    }

    public void addState(String newText) {
        TextState newState = new TextState(newText);
        current.next = newState;
        newState.prev = current;
        current = newState;
        clearRedoHistory();
        if (++historySize > maxHistorySize) {
            removeOldestState();
        }
        System.out.println("State added: " + newText);
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void displayCurrentState() {
        System.out.println("Current State: " + current.content);
    }

    private void clearRedoHistory() {
        current.next = null;
    }

    private void removeOldestState() {
        if (head.next != null) {
            head = head.next;
            head.prev = null;
            historySize--;
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nText Editor - Undo/Redo Menu");
            System.out.println("1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter new text state: ");
                String newText = sc.nextLine();
                editor.addState(newText);
            } else if (choice == 2) {
                editor.undo();
            } else if (choice == 3) {
                editor.redo();
            } else if (choice == 4) {
                editor.displayCurrentState();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
