/**
 * Operating Systems Assingment 2
 * 
 * Alan Herculano Diniz, Israel Santos & Rafael Belmock Pedruzzi
 * 
 * Implementing and solving the Producer/Consumer problem
*/

package SOTrab2;

import java.util.Random;

/**
 * Implementing the class that will get messages from the buffer
 */
public class Consumer extends Thread
{
	static private Buffer b; // Buffer associated with Consumer class.

	/**
	 * Setting the buffer that will hold the messages that will be consumed.
	 */
	public static void SetBuffer(Buffer buffer)
	{
		b = buffer;
	}

	/**
	 * Thread's main execution function
	 * 
	 * This will consume a message from the buffer and then print it.
	 */
	@Override
	public void run()
	{
		while (true)
		{
			Message m = b.remove();
			long threadId = Thread.currentThread().getId();

			System.out.println("Message consumed by thread id=" + threadId + "; Priority = " + m.GetPriority()
					+ "; Message:\n" + m.GetMsg() + "\n");

			try
			{
				Thread.sleep(RandomWTime() * 1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return a random int between 1 and 5.
	 */
	private int RandomWTime() {
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}
