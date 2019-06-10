/**
 * Operating Systems Assingment 2
 * 
 * Alan Herculano Diniz, Israel Santos & Rafael Belmock Pedruzzi
 * 
 * Implementing and solving the Producer/Consumer problem
*/

package SOTrab2;

import java.util.Queue;
import java.util.LinkedList;

public class Buffer {
    private Queue<Message>[] buffer = new Queue[4]; // priority queue.
    private Queue<Long> waitingQ = new LinkedList<>(); // waiting queue that keeps the arrival order.

    public Buffer() {
        for (Queue q : buffer) {
            q = new LinkedList<>();
        }
    }

    public synchronized void insert(Message m) {
        priority = m.GetPriority();
        threadId = Thread.currentThread().getId();
        waitingQ.add(threadId); // adding thread to waiting queue.
        // Waiting until there is room in the queue and thread is the first in the
        // waiting queue:
        if ((buffer[priority]).size() >= 3 && waitingQ.peek() != priority) {
            System.out.println("Priority queue " + priority + " is full. Blocking thread #" + threadId);
            while ((buffer[priority]).size() >= 3 && waitingQ.peek() != priority) {
                wait();
            }
            System.out.println("Opened room in priority queue " + priority + ". Unlocking thread #" + threadId);
        }
        waitingQ.remove(); // exiting waiting queue.
        buffer[priority].add(m); // adding message to priority queue.
    }

    public synchronized Message remove() {

    }
}
