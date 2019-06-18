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

/**
 * Implementing the class that will hold the message buffer and handle
 * synchronization
 */
public class Buffer
{
	private Queue<Message>[] buffer = new Queue[4]; // priority queues.
	private Queue<Long>[] waitingQ = new Queue[4]; // waiting queues that keeps the arrival order.

	/**
	 * Buffer constructor method
	 */
	public Buffer()
	{
		// Initializing queues:
		for (int i = 0; i < 4; i++)
		{
			buffer[i] = new LinkedList<>();
			waitingQ[i] = new LinkedList<>();
		}
	}

	/**
	 * Inserting a message in the buffer
	 * 
	 * @param Message: the message that will be inserted in the buffer
	 */
	public synchronized void insert(Message m)
	{
		int priority = m.GetPriority();
		long threadId = Thread.currentThread().getId();
		waitingQ[priority].add(threadId); // Adding the thread to the waiting queue.
		// Waiting until there's room in the queue and the thread is the first in the corresponding waiting queue:
		if ((buffer[priority]).size() >= 3 && waitingQ[priority].peek() != priority)
		{
			System.out.println("Priority queue " + priority + " is full. Blocking thread id=" + threadId + "\n");
			while ((buffer[priority]).size() >= 3 && waitingQ[priority].peek() != priority)
			{
				try
				{
					wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("Opened room in priority queue " + priority + ". Unlocking thread id=" + threadId + "\n");
		}
		waitingQ[priority].remove(); // removing the thread from the waiting queue.
		buffer[priority].add(m); // adding the message to the priority queue.
		notifyAll(); // Telling the consumers that they can, well, consume.
	}

	/**
	 * Removing a message from the buffer
	 * 
	 * @return the removed Message object
	 */
	public synchronized Message remove()
	{
		long threadId = Thread.currentThread().getId();
		// Waiting until there is a message in the buffer:
		if (buffer[0].size() == 0 && buffer[1].size() == 0 && buffer[2].size() == 0 && buffer[3].size() == 0)
		{
			System.out.println("Buffer is empty. Blocking thread id=" + threadId + "\n");
			while (buffer[0].size() == 0 && buffer[1].size() == 0 && buffer[2].size() == 0 && buffer[3].size() == 0)
			{
				try
				{
					wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("Buffer got a message. Unlocking thread id=" + threadId + "\n");
		}

		// Searching for the first message in the buffer:
		int i;
		for(i=0;i<4;i++)
		{
			if(buffer[i].size() > 0)
			{
				break;
			}
		}

		Message m = buffer[i].remove(); // Removing message from buffer.
		notifyAll(); // Telling the producers that there are a new space in the buffer.
		return m;
	}
}
