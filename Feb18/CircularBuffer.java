package Feb18;

import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity; // Move rear in a circular manner
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite the oldest element
        }
    }

    public int remove() {
        if (size == 0) throw new IllegalStateException("Buffer is empty");
        int removed = buffer[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }

    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display(); // Output: Buffer: 1 2 3

        buffer.insert(4); // Overwrites 1
        buffer.display(); // Output: Buffer: 2 3 4

        buffer.remove();
        buffer.display(); // Output: Buffer: 3 4
    }
}
