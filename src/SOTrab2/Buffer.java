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
    private Queue<Message>[] buffer = new Queue[4]; // priority queues.
    private Queue<Long>[] waitingQ = new Queue[4]; // waiting queues that keeps the arrival order.

    public Buffer() {
        for (int i = 0; i < 4; i++) {
            buffer[i] = new LinkedList<>();
            waitingQ[i] = new LinkedList<>();
        }
    }

    public synchronized void insert(Message m) {
        int priority = m.GetPriority();
        long threadId = Thread.currentThread().getId();
        waitingQ[priority].add(threadId); // adding thread to waiting queue.
        // Waiting until there is room in the queue and thread is the first in the corresponding waiting queue:
        if ((buffer[priority]).size() >= 3 && waitingQ[priority].peek() != priority) {
            System.out.println("Priority queue " + priority + " is full. Blocking thread id=" + threadId + "\n");
            while ((buffer[priority]).size() >= 3 && waitingQ[priority].peek() != priority) {
                try{ wait(); }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Opened room in priority queue " + priority + ". Unlocking thread id=" + threadId + "\n");
        }
        waitingQ[priority].remove(); // removing thread from waiting queue.
        buffer[priority].add(m); // adding message to priority queue.
        notifyAll(); // notifying waiting consumers.
    }

    public synchronized Message remove() {
        long threadId = Thread.currentThread().getId();
        // Checking if buffer is empty:
        if (buffer[0].size() == 0 && buffer[1].size() == 0 && buffer[2].size() == 0 && buffer[3].size() == 0) {
            System.out.println("Buffer is empty. Blocking thread id=" + threadId + "\n");
            while (buffer[0].size() == 0 && buffer[1].size() == 0 && buffer[2].size() == 0 && buffer[3].size() == 0) {
                try{ wait(); }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Buffer got a message. Unlocking thread id=" + threadId + "\n");
        }

        // Searching for the first message in the buffef:
        int i;
        for(i=0;i<4;i++) {
            if(buffer[i].size() > 0) {
                break;
            }
        }

        Message m = buffer[i].remove();
        notifyAll();
        return m;
    }
}
