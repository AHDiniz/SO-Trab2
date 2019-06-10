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
    private Queue<Message>[] buffer = new Queue[4];

    public Buffer() {
        for (Queue q : buffer) {
            q = new LinkedList<>();
        }
    }

    public synchronized void insert(Message mensage) {

    }

    public synchronized Message remove() {

    }
}
