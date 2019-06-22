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
	static private Buffer b; // The message buffer

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

			System.out.println("Message consumed by thread id=" + threadId + "; Priority = " + m.GetPriority() + "; Message:\n" + m.GetMsg() + "\n");

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
	 * Setting the buffer that will hold the messages that will be consumed.
	 * 
	 * @param buffer: message buffer
	 */
	public static void SetBuffer(Buffer buffer)
	{
		b = buffer;
	}

	/**
	 * Setting a random amount of time that the consumer will have to wait
	 */
	private int RandomWTime()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}
